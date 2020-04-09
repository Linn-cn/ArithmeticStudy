package com.zhulin.sort;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname MaoPaoSort
 * @description
 * @create 2020-03-04 13:18
 **/
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] numbers = {1,3,4,45,6,7,9};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}
