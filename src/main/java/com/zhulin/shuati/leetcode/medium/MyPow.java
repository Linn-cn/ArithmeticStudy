package com.zhulin.shuati.leetcode.medium;

/**
 * 题目：50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MyPow {
    /**
     * 暴力法：时间复杂度为O(n)
     */
    public static double myPow(double x, int n) {
        // 复数情况下：例如 2^-2 = 2 * 1/2 = 1/4 = 0.25
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * 分治实现，思路，例如2^5 = 2^2 * 2^2 * 2;
     * 每次求一半的值，只需要判断奇数偶数即可
     */
    public static double myPow1(double x, int n) {
        // 复数情况下：例如 2^-2 = 2 * 1/2 = 1/4 = 0.25
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return recursion(x, n);
    }

    public static double recursion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = recursion(x, n / 2);
        return ((n & 1) == 0) ? half * half : half * half * x;
    }

    public static double myPow2(double x, int n) {
        // 复数情况下：例如 2^-2 = 2 * 1/2 = 1/4 = 0.25
        if (n == 0) {
            return 1.0;
        }
        if (n < 0 && n != Integer.MIN_VALUE) {
            return 1 / myPow2(x, -n);
        } else if (n % 2 != 0) {
            return x * myPow2(x, n - 1);
        }
        return myPow2(x * x, n / 2);
    }

    public static double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    /**
     * case 3：快速幂写法
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     */
    public static double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double xContribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= xContribute;
            }
            // 将贡献不断地平方
            xContribute *= xContribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(myPow(1,-2147483648));
        System.out.println(myPow2(2,-2147483648));
        // System.out.println(2147483648);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // System.out.println(myPow3(1,-2147483648));
    }
}
