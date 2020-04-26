package com.zhulin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class GenerateParenthesis {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        _generate(0,0, n,"",list);
        return list;
    }

    /**
     *
     * @param left 左括号
     * @param right 右括号
     * @param n 限制条件
     * @param s 当前字符串
     * @param list 结果集
     */
    private static void _generate(int left, int right, int n, String s,List<String> list) {
        // 终止条件
        if (left == n && right == n){
            list.add(s);
            System.out.println("s = " + s);
            return;
        }

        // 当前层逻辑

        // 进入到下一层
        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        // 左括号随时可以添加，只要不大于n
        if (left < n) {
            _generate(left + 1, right, n, s + "(",list);
        }
        // 左括号大于右括号，就可以添加右括号
        if (left > right) {
            _generate(left, right + 1, n, s + ")",list);
        }
        // 清理当前层
    }
}
