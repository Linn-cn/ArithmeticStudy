package com.zhulin.shuati.leetcode.simple;

import java.util.Arrays;

/**
 * 题目：旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate1(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 好low
     */
    public static void rotate1(int[] nums, int k) {
        while (k > 0){
            int tailNum = nums[nums.length - 1];
            int temp = nums[0];
            int exchange;
            for (int i = 1; i < nums.length; i++) {
                if (i == 1){
                    temp = nums[i];
                    nums[i] = nums[i - 1];
                }else {
                    exchange = temp;
                    temp = nums[i];
                    nums[i] = exchange;
                }
                System.out.println(Arrays.toString(nums));
            }
            nums[0] = tailNum;
            k--;
            System.out.println("一圈：" + Arrays.toString(nums));
        }
    }

    /**
     * 优化上面的代码  暴力解法
     * 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
     */
    public static void rotate2(int[] nums, int k) {
        while (k > 0){
            int tailNum = nums[nums.length - 1];
            int temp;
            for (int i = 0; i < nums.length; i++) {
                temp = nums[i];
                nums[i] = tailNum;
                tailNum = temp;
            }
            k--;
        }
    }

    /**
     * 使用额外的数组空间
     */
    public static void rotate3(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


    /**
     *
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     *
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
     *
     * 假设 n=7 且 k=3 。
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
