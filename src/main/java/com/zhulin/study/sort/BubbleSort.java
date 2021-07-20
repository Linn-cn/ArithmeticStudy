package com.zhulin.study.sort;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname BubbleSort
 * @description 冒泡排序
 * @create 2020-03-04 13:18
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 45, 1, 6, 7, 9};
        int[] numbers2 = {5, 23, 45, 11, 2, 27, 9};
        bubbleSort2(numbers);
        bubbleSort2(numbers2);
    }

    /**
     * 每次将最大的值往后冒泡
     * @param
     */
    public static void bubbleSort(int[] numbers) {
        if (numbers.length <= 1) return;
        for (int i = 0; i < numbers.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static void bubbleSort2(int[] number){
        if (number.length <= 1) return;
        for (int i = 0; i < number.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < number.length - i - 1; j++) {
                if (number[j] > number[j + 1]){
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        System.out.println(Arrays.toString(number));
    }
}
