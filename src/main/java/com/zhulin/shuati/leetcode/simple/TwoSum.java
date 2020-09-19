package com.zhulin.shuati.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目：两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }

    // case1：老规矩，双重循环，时间复杂度为O(n^2)
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[2];
    }

    // case2：利用哈希表的特性，将查找转为哈希查找，这样时间复杂度为 O(1) + O(n) = O(n)
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(Math.max((int) (nums.length/0.75f) + 1, 16));
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[] {i,map.get(temp)};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
