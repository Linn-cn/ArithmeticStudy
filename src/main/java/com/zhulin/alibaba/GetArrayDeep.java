package com.zhulin.alibaba;


import java.util.Stack;

/**
 * 获取嵌套数组深度
 * 说明：给定一个带嵌套的数组，实现一个方法可获取嵌套数组的最大深度，
 *   数组无嵌套子数组，则返回0，有一层嵌套子数组则1，依此类推。
 * 示例：
 *   getArrayDeep([1, 2, [3, [1, [0]]]]); // 返回 3
 *   getArrayDeep([]); // 返回 0
 *   getArrayDeep([[[[]]]]); // 返回 3
 *   getArrayDeep([0, [2], [2, [3]]]); // 返回 2
 */
public class GetArrayDeep {
    public static void main(String[] args) {
        System.out.println(getArrayDeep("[1, 2, [3, [1, [0]]]]"));
    }

    public static int getArrayDeep(String s){
        int count = 0;
        Stack<Character> stack = new Stack<>();
        // 变成字符数组
        char[] chars = s.toCharArray();
        // 循环遍历
        for (char aChar : chars) {
            // 只有括号才进栈
            if (aChar == '[' || aChar == ']'){
                // 栈是空的，则直接push
                if (stack.empty()) {
                    stack.push(aChar);
                    continue;
                }
                // 当前字符为]，就去栈中抵消一个[，代表一个数组
                if (aChar == ']') {
                    // 比较此时栈中的最大深度和当前的最大深度，取其最大值
                    count = Math.max(stack.size(),count);
                    stack.pop();
                    continue;
                }
                stack.push(aChar);
            }
        }
        return count - 1;
    }
}
