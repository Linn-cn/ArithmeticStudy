package com.zhulin.shuati.leetcode.simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
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
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class StackIsValid {

    private static HashMap<Character,Character> map = new HashMap<>();

    public StackIsValid(){
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }

    public static void main(String[] args) {
        System.out.println(isValid("((()(())))"));
    }

    /**
     * 解题思路：最近相关性 stack、先来后到 queue
     * @return
     */
    public static boolean isValid(String s) {
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
}
