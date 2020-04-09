package com.zhulin.sort;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname ChaRuSort
 * @description
 * @create 2020-03-04 14:07
 **/
public class ChaRuSort {
    public static void main(String[] args) {
        int[] numbers = {3,1,4,45,6,7,9};
        insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] insertionSort(int[] array) {
        int len;
        // 基本情况下的数组可以直接返回
        if(array == null || (len = array.length) == 0 || len == 1) {
            return array;
        }
        int current;
        for (int i = 0; i < len - 1; i++) {
            // 第一个数默认已排序，从第二个数开始
            current = array[i + 1];
            // 前一个数的下标
            int preIdx = i;

            // 拿当前的数与之前已排序序列逐一往前比较，
            // 如果比较的数据比当前的大，就把该数往后挪一步
            while (preIdx >= 0 && current < array[preIdx]) {
                array[preIdx + 1] = array[preIdx];
                preIdx--;
            }
            // while循环跳出说明找到了位置
            array[preIdx + 1] = current;
        }
        return array;
    }
}
