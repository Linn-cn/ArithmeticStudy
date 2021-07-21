package com.zhulin.shuati.leetcode.simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目：20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class StackIsValid {

    private static HashMap<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static void main(String[] args) {
        System.out.println(isValid1("()[(]]"));
    }

    /**
     * 解题思路：最近相关性 stack、先来后到 queue
     *
     * @return
     */
    public static boolean isValid0(String s) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char aChar : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(aChar);
                continue;
            }
            if (stack.peek().equals('(') && aChar == ')') {
                stack.pop();
                continue;
            }
            if (stack.peek().equals('{') && aChar == '}') {
                stack.pop();
                continue;
            }
            if (stack.peek().equals('[') && aChar == ']') {
                stack.pop();
                continue;
            }
            stack.push(aChar);
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String str) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (str == null || str.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (str.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            // 判断是否是合法括号
            if (map.containsValue(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)) {
                if (stack.empty() || !stack.pop().equals(map.get(ch))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
