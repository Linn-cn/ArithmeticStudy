package com.zhulin.study.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
 * <p>
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * <p>
 * 解释：在所有可能的解：{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 字典序最小。
 * <p>
 * 所谓字典序就是，给定两个数组：x = [x1,x2,x3,x4]，y = [y1,y2,y3,y4]，如果 0 ≤ p < i，xp == yp 且 xi < yi，那么我们认为 x 的字典序小于 y。
 *
 * @author Zhu Lin
 * @date 2022/4/12
 */
public class FindSmallSeq {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSmallSeq(new int[]{3, 5, 2, 6}, 2)));
    }

    public static int[] findSmallSeq(int[] nums, int k) {
        int[] ans = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int remainSize = nums.length - i;
            while (!stack.isEmpty() && (stack.size() + remainSize > k) && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        // 如果递增栈里面的数太多，那么我们只需要取出前k个就可以了。
        // 多余的栈中的元素需要扔掉。
        while (stack.size() > k) {
            stack.pop();
        }

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
