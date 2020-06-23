package com.zhulin.shuati.leetcode.simple;

import java.util.Arrays;

/**
 * 题目：移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] numbers = {0,1,0,3,12};
//        case1 : double loop
//        int replaceIndex = 0, count = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] != 0){
//                numbers[replaceIndex++] = numbers[i];
//            }else {
//                count++;
//            }
//        }
//        for (int j = numbers.length - count; j < numbers.length; j++){
//            numbers[j] = 0;
//        }

//        case2：index operation
//        int replaceIndex = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] != 0){
//                numbers[replaceIndex] = numbers[i];
//                if (i != replaceIndex){
//                    numbers[i] = 0;
//                }
//                replaceIndex++;
//            }
//        }

//        case3：swap
        int replaceIndex = 0;
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                temp = numbers[replaceIndex];
                numbers[replaceIndex] = numbers[i];
                numbers[i] = temp;
                replaceIndex++;
            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}
