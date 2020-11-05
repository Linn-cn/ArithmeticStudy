package com.zhulin.shuati.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：78.子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
    }

    /**
     * 循环枚举
     */
    public static List<List<Integer>> subsets(int[] nums) {
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
