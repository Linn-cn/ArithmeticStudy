package com.zhulin.study.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 【题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 * <p>
 * 输入：[5, 2]
 * <p>
 * 输出：[1, -1]
 * <p>
 * 解释：因为元素 5 的右边离我最近且比我小的位置应该是 A[1]，最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
 *
 * @author Zhu Lin
 * @date 2022/4/12
 */
public class FindRightSmall {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightSmall(new int[]{5, 2})));
    }

    public static int[] findRightSmall(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 记录下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            // 如果当前元素小于左边的元素，则小数消除大数，并记录结果
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                ans[stack.pop()] = i;
            }
            // 其他情况入栈
            stack.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

}
