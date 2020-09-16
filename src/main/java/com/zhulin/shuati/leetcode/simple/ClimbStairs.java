package com.zhulin.shuati.leetcode.simple;

/**
 * 题目：爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {
    public static int[] caches = new int[5];
    public static void main(String[] args) {
        System.out.println(ClimbStairs2(5));
    }


    // case1：没有任何缓存的递归 时间复杂度为2^n次方
    public static int ClimbStairs1(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return ClimbStairs1(n - 1) + ClimbStairs1(n - 2);
    }

    // case2：加一个缓存
    public static int ClimbStairs2(int n){
        if (n < 3) return n == 1 ? 1 : 2;
        int a1 = 1,a2 = 2,a3;
        for (int i = 3; i <= n; i++) {
            a3 = a1 + a2;
            a1 = a2;
            a2 = a3;
        }
        return a2;
    }
}
