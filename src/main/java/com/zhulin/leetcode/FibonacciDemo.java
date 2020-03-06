package com.zhulin.leetcode;

import java.time.Clock;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname FibonacciDemo
 * @description 求第N个斐波那契数
 * @create 2020-03-04 17:38
 **/
public class FibonacciDemo {

    public static void main(String[] args) {
        System.out.println(getFibonacci(25));
        System.out.println(recursionFibonacci(25));
    }

    public static int getFibonacci(int n){
        if (n < 3) return n == 0 ? 0 : 1;
        int temp,x = 0, z = 1,y = 1;
        for (int i = 3; i <= n; i++) {
            temp = x + y + z;
            x = y;
            y = z;
            z = temp;
        }
        return z;
    }

    public static int recursionFibonacci(int n){
        if (n < 3) return n == 0 ? 0 : 1;
        return recursionFibonacci(n - 3) + recursionFibonacci(n - 2) + recursionFibonacci(n - 1);
    }

}
