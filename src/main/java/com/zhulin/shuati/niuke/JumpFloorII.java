package com.zhulin.shuati.niuke;

import java.util.Arrays;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&&tqId=11162&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author Linn-cn
 * @create 2020/10/11
 */
public class JumpFloorII {

    public int jumpFloorII(int target) {
        if (target <= 2){
            return target;
        }
        int[] dp = new int[target + 1];
        // 初始化每一种都可以直接从 0 跳到 n
        Arrays.fill(dp, 1);
        for (int i = 2; i <= target; i++) {
            for (int j = i - 1; j >= 1; j--) {
                //第 n 个状态是由前 n - 1 种状态推导出来，就是累加！
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
