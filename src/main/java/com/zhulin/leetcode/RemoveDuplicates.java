package com.zhulin.leetcode;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname RemoveDuplicates
 * @description
 * @create 2020-03-06 10:56
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums  = {1,1,2,3,2,1};
//        case1: 自己想的，很low，但是长度对了
//        int replaceIndex = 0;
//        for (int i = 0; i < nums .length; i++) {
//            boolean flag = true;
//            for (int j = 0; j <= replaceIndex; j++) {
//                if (nums [j] == nums [i]){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                replaceIndex++;
//                nums [replaceIndex] = nums [i];
//            }
//        }
        
//        case2: 双指针遍历  但是长度不对
        int replaceIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[replaceIndex]){
                nums[++replaceIndex] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(replaceIndex + 1);
    }

}
