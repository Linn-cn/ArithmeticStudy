package com.zhulin.shuati.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：169.多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(Math.max(16, (int) (nums.length / .75f) + 1));
        int maxValue = nums[0];
        int maxCount = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                if (count > maxCount) {
                    maxValue = num;
                    maxCount = count;
                }
                map.put(num, count);
                continue;
            }
            map.put(num, 1);
        }
        return maxValue;
    }

    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
    }
}
