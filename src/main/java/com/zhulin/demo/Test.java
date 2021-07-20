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
        int amount = 6;
        int[] coins = {5, 1, 2, 10, 6, 4};
        System.out.println(getMaxCounts(amount, coins));
        // int[][] adjMatrix = {
        //         {0,-1,3,-1},
        //         {2,0,-1,-1},
        //         {-1,7,0,1},
        //         {6,-1,-1,0},
        // };
        //
        // getShortestPaths(adjMatrix);
        // for (int[] matrix : adjMatrix) {
        //     for (int j = 0; j < adjMatrix[0].length; j++) {
        //         System.out.print(matrix[j] + " ");
        //     }
        // }
    }

    public static int getMaxCounts(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    public static void getShortestPaths(int[][] adjMatrix) {
        for (int k = 0; k < adjMatrix.length; k++) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    if (adjMatrix[i][k] != -1 && adjMatrix[k][j] != -1) {
                        int temp = adjMatrix[i][k] + adjMatrix[k][j];
                        if (adjMatrix[i][j] == -1 || adjMatrix[i][j] > temp) {
                            adjMatrix[i][j] = temp;
                        }
                    }
                }
            }
        }
    }
}
