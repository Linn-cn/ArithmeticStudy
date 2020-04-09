package com.zhulin.leetcode.medium;

/**
 * 题目: 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(nums));
    }

    // 涉及左右边界遍历，以下写法是固定的，需要记住
//    for (int i = 0; i < height.length - 1; i++) {
//        for (int j = i + 1; j < height.length; j++) {
//        }
//    }

    /**
     * case1: 枚举 left bar，right bar， (x - y) * (x < y ? x : y)
     * 时间复杂度为：O(n^2)
     */
    public static int maxArea1(int[] height) {
        int temp1 = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp2 = (j - i) * (Math.min(height[i], height[j]));
                temp1 = Math.max(temp1,temp2);
            }
        }
        return temp1;
    }

    /**
     * case2: 左右边界 i,j 同时向中间收敛 又叫左右夹逼
     * 时间复杂度为：O(n)
     */
    public static int maxArea2(int[] height){
        int max = 0;
        for (int i = 0,j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max,area);
        }
        return max;
    }
}
