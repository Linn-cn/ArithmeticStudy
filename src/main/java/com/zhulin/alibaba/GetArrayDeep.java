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
        System.out.println(getArrayDeep("[0, [2], [2, [3]]]"));
    }

    public static int getArrayDeep(String s){
        int count = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '[' || aChar == ']'){
                if (stack.empty()) {
                    stack.push(aChar);
                    continue;
                }
                if (stack.peek().equals('[') && aChar == ']') {
                    stack.pop();
                    count++;
                    continue;
                }
                stack.push(aChar);
            }
        }
        return count;
    }
}
