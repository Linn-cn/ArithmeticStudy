package com.zhulin.leetcode.simple;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 题目：最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        MinStack2 stack2 = new MinStack2();
//        for (int i = 0; i < 11; i++) {
//            stack.push((int) (Math.random() * 100));
//        }
        stack.push(2);
        stack.push(35);
        stack.push(3);
        stack.push(46);
        stack.push(1);
        stack.push(1);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    private int[] elementData;

    private int elementCount;

    private int DEFAULT_CAPACITY = 10;

    private ArrayList<Integer> minData;

    /** initialize your data structure here. */
    public MinStack() {
        elementData = new int[DEFAULT_CAPACITY];
        minData = new ArrayList<>();
        elementCount = 0;
    }

    public void push(int x) {
        if (elementCount >= elementData.length){
            int[] newElementData = new int[elementData.length * 2];
            System.arraycopy(elementData,0,newElementData,0,elementData.length);
            elementData = newElementData;
        }
        elementData[elementCount++] = x;
        minData.add(x);
        minData.sort(Integer::compareTo);
    }

    public void pop() {
        if (elementData[--elementCount] == minData.get(0)){
            minData.remove(0);
        }
        elementData[elementCount] = 0;
    }

    public int top() {
        return elementData[elementCount-1];
    }

    public int getMin() {
        return minData.get(0);
    }


    /**
     * 直接利用原生的stack实现，一个辅助栈用来在O(1)时间内返回最小值
     */
    static class MinStack2 {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack2() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }
        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_stack.peek();
        }
    }

}
