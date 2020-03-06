package com.zhulin.leetcode;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname MoveZeroes
 * @description 移动零
 * @create 2020-03-05 20:56
 **/
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
