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
        int[] numbers1 = {124, 23, 45, 5, 3, 7, 9};
        int[] numbers2 = {4, 8, 25, 7, 58, 63, 19};
        selectSort(numbers1);
        selectSort(numbers2);
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 每次将最小的值放到前面
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) index = j;
            }
            if (index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        System.out.println("选择排序后：" + Arrays.toString(array));
    }

    public static void selectSort2(int[] num){
        if (num.length < 2){
            return;
        }
        for (int i = 0; i < num.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                minIndex = num[j] < num[minIndex] ? j : minIndex;
            }
            if (minIndex != i){
                int temp = num[i];
                num[i] = num[minIndex];
                num[minIndex] = temp;
            }
        }
        System.out.println("选择排序后：" + Arrays.toString(num));
    }
}
