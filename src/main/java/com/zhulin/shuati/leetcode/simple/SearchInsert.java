package com.zhulin.shuati.leetcode.simple;

/**
 * 题目：搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SearchInsert {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1]) return nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target) {
                return i;
            }
        }
        return 0;
    }

    public int searchInsert1(int[] nums,int target){
        if (nums[nums.length -1] < target) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            // 当nums[mid] < target的时候，一定不是解
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
