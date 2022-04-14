package com.zhulin.study.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 题目：给定一个数组，要找到这个数组里面每个元素左边比我小的元素的位置
 * - 注意：是左边第一个比我小的，如果有多个的话
 * - 如果没有，那么用-1表示。
 * <p>
 * 返回：一个数组，表示左边比我小的数的下标位置
 * <p>
 * 输入：[5, 6]
 * 输出：[-1, 0]
 * 解释：A[0] = 5，左边比我小的元素没有, 所以记录为 = -1
 * A[1] = 6, 左边比我小的元素为A[0] = 5，所以记录为   = 0
 * 所以返回值是[-1, 0]
 */
public class FindLeftSmall {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findLeftSmall(new int[]{1, 2, 4, 9, 4, 0, 5})));
    }

    public static int[] findLeftSmall(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 记录下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = A.length - 1; i >= 0; i--) {
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


class Verify {
    private static int findLeftSmall(int[] A, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (A[j] < A[i]) {
                return j;
            }
        }
        return -1;
    }

    private static void check(int[] A, int[] ans) {
        if (A == null || A.length == 0) {
            return;
        }

        final int N = A.length;
        for (int i = 0; i < N; i++) {
            final int r = ans[i];
            if (r != findLeftSmall(A, i)) {
                System.out.println("ERROR");
            }
        }
    }

    public static void DoubleCheck(int[] A) {
        int[] ans = FindLeftSmall.findLeftSmall(A);
        check(A, ans);
    }

    private static int NextInt() {
        final double d = Math.random();
        final int i = (int) (d * 1000);
        return i;
    }

    public static void RandomCheck() {
        for (int i = 0; i < 100; i++) {
            final int len = NextInt() + 1;
            int[] A = new int[len];
            for (int j = 0; j < len; j++) {
                A[j] = NextInt();
            }

            DoubleCheck(A);
        }
    }
}

class Practice03B {
    public static void main(String[] args) {
        Verify.DoubleCheck(new int[]{5, 4});
        Verify.DoubleCheck(new int[]{1, 2, 4, 9, 4, 0, 5});

//        Verify.RandomCheck();

    }
}
