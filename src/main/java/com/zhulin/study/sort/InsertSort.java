package com.zhulin.study.sort;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname 插入排序
 * @description
 * @create 2020-03-04 14:07
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 45, 1, 6, 7, 9};
        insertSort2(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void insertSort1(int[] array) {
        int len;
        // 基本情况下的数组可以直接返回
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
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
    }


    public static void insertSort2(int[] array) {
        // 默认第一个有序
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            // 从有序数组的后面往前比较，大于temp的值都得后移
            for (; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            // 碰到小于或等于的数停止，由于多减了1，所以加上1后，赋值为插入值temp
            array[j + 1] = temp;
        }
    }
}
