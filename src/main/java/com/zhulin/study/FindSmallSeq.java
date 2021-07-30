package com.zhulin.study;

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
 * @date 2021/7/28
 */
public class FindSmallSeq {
  public static void main(String[] args) {
    int[] nums = {3, 5, 2, 6};
    int k = 2;
    System.out.println(Arrays.toString(findSmallSeq(nums, k)));
  }

  public static int[] findSmallSeq(int[] A, int k) {
    int[] ans = new int[k];
    // 声明栈
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < A.length; i++) {
      final int x = A[i];
      final int remainNumber = A.length - i;
      while (!stack.isEmpty() && (remainNumber + stack.size() > k) && (stack.peek() > x)) {
        stack.pop();
      }
      stack.push(x);
    }
    // 如果递增栈里面的数太多，那么我们只需要取出前k个就可以了。
    // 多余的栈中的元素需要扔掉。
    while (stack.size() > k) {
      stack.pop();
    }
    // 把k个元素取出来，注意这里取的顺序!
    for (int i = k - 1; i >= 0; i--) {
      ans[i] = stack.pop();
    }
    return ans;
  }
}
