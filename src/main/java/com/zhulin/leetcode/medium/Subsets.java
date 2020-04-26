package com.zhulin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Subsets
 * @description
 * @create 2020-04-26 11:28
 **/
public class Subsets {

    /**
     * 循环枚举
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            int size = output.size();
            // 每次将新的值跟已经在数组中的值追加
            for (int i = 0; i < size; i++) {
                output.add(new ArrayList<Integer>(output.get(i)){{add(num);}});
            }
        }
        return output;
    }

    /**
     * 递归枚举
     */
    public static void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            res.add(new ArrayList<Integer>(res.get(j)){{add(nums[i]);}});
        }
        recursion(nums, i + 1, res);
    }
}
