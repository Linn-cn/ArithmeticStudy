package com.zhulin.shuati.niuke;

import java.util.Stack;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname StackRealizeQueue
 * @description
 * 链接：https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6?answerType=1&f=discussion
 * 来源：牛客网
 *
 * push操作就直接往stack1中push， pop操作需要分类一下：如果stack2为空，那么需要将stack1中的数据转移到stack2中，然后在对stack2进行pop，如果stack2不为空，直接pop就ok。
 * @create 2020-06-08 16:43
 **/
public class StackRealizeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
