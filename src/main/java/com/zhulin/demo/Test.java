package com.zhulin.demo;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Test
 * @description
 * @create 2020-03-08 19:01
 **/
public class Test {
    public static void main(String[] args) {
        int[] number = {1,2,3,4,5};
        reserve(number);
        System.out.println(Arrays.toString(number));
    }

    public static void reserve(int[] number){
        for(int i= 0,j = number.length - 1; i != j; i++,j--){
            int temp = number[i];
            number[i] = number[j];
            number[j] = temp;
        }
    }
}
