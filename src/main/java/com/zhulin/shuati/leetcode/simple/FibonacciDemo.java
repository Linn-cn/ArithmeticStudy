package com.zhulin.shuati.leetcode.simple;

/**
 * 题目：第n个斐波那契数
 * 泰波那契序列Tn定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
