package com.zhulin.shuati.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：中心对称数 2
 *
 * @author Linn-cn
 * @description 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * 找出所有长度为n的中心对称数
 * 示例 1:
 * 输入:  "69"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:  "88"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入:  "962"
 * 输出: false
 * @create 2020/08/13
 */
public class IsStrobogrammatic {
    public static void main(String[] args) {

    }

    public static List<String> helper(int n, int m) {
        // 第一步：判断输入或者状态是否非法？
        if (n < 0 || m < 0 || n > m) {
            throw new IllegalArgumentException("invalid input");
        }

        // 第二步：判断递归是否应当结束
        if (n == 0) return new ArrayList<String>() {{
            add("");
        }};

        if (n == 1) return new ArrayList<String>() {{
            add("0");
            add("1");
            add("8");
        }};

        // 第三步：缩小问题规模
        List<String> list = helper(n - 2, m);

        // 第四步：整合结果
        ArrayList<String> res = new ArrayList<>();

        for (String s : list) {
            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
