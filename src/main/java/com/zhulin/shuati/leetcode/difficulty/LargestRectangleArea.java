package com.zhulin.shuati.leetcode.difficulty;

/**
 * 题目: 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 **/
public class LargestRectangleArea {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }

    /**
     * 错误版本
     */
    public static int largestRectangleArea1(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i < heights.length - 1) {
                int temp = heights[i] < heights[i + 1] ? heights[i] * 2 : heights[i + 1] * 2;
                area = Math.max(temp, area);
            }
            area = Math.max(heights[i], area);
        }
        return area;
    }

    public static int largestRectangleArea2(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minheight = Integer.MAX_VALUE;
                // 判斷在i和j中間有沒有更小的
                for (int k = i; k <= j; k++)
                    minheight = Math.min(minheight, heights[k]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }


}
