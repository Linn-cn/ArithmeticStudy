package com.zhulin.demo;

import java.util.Scanner;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Test1
 * @description
 * @create 2020-03-10 22:15
 **/
public class Test1 {

    public static void main(String[] args) {
        System.out.println("请输入数组所有元素中前多少个元素的平均值：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("请输入数组元素");
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextFloat();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        float avg = arrayavg(arr, n) / n;
        System.out.print("数组所有元素中前" + n + "个元素的平均数是：" + avg);
    }

    static float arrayavg(float[] arr, int n) {
        if (n == 0)
            return 0;
        else
            return (arr[n - 1] + (arrayavg(arr, n - 1)));
    }
}


