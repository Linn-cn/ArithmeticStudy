package com.zhulin.study.sort;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname SelectSort
 * @description 选择排序
 * @create 2020-04-16 12:29
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 45, 1, 6, 7, 9};
        selectSort(numbers);
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 每次将最小的值放到前面
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]){
                    index = j;
                }
            }
            if (index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        System.out.println("简单选择排序后：" + Arrays.toString(array));
    }
}
