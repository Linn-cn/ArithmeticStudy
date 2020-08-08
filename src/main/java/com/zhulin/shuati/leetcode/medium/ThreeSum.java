package com.zhulin.shuati.leetcode.medium;

import java.util.*;
import java.util.stream.Stream;

/**
 * 题目：三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // int[] nums = {-1, 0, 1, 0};
        // int[] nums = {1, 2, -2, -1};
        List<List<Integer>> lists = threeSum2(nums);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    // case1：暴力求解，三层循环，时间复杂度为O(n^3)   好low，直接超时
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(list);
                        if (lists.size() == 0) {
                            lists.add(list);
                        } else {
                            for (int l = 0; l < lists.size(); l++) {
                                List<Integer> integers = lists.get(l);
                                Integer[] array1 = integers.toArray(new Integer[0]);
                                Integer[] array2 = list.toArray(new Integer[0]);
                                if (Arrays.equals(array1, array2)) {
                                    break;
                                }
                                if (l == lists.size() - 1) {
                                    lists.add(list);
                                }
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }

    // case2：利用hash表记录，先遍历一遍，将元素放入hash，然后在循环去判断hash表里是否有数相加为0。O(n^2)
    // FIXME 存在重复问题
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length <= 3) {
            if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
                lists.add(new ArrayList<>(Arrays.asList(nums[0], nums[1], nums[2])));
            }
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            // if (i >= 1  && (nums[i] == nums[i - 1])) continue;
            int key = -(nums[i] + nums[j]);
            if (map.containsKey(key)) {
                lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], key)));
            }
            map.put(nums[i], i);
        }
        return lists;
    }

    // 排序加双指针
    public static List<List<Integer>> threeSum3(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            // 如果大于零，说明接下来的全部都大于零
            if (nums[k] > 0) break;
            // 跳过nums[k]重复的情况
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            // i从k后一位开始，j从末尾开始
            int i = k + 1, j = nums.length - 1;
            // 只要i和j还不相撞就一直循环
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                // 小于零，说明在排好序的情况下，i得往后走
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                    // 大于零，说明在排好序的情况下，j得往前走
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    // 说明需要添加
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 前置++，当条件不满足的时候，此时i或者j已经到了下一位
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }
}
