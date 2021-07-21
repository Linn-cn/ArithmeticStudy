
package com.zhulin.study;

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
 * @date 2021/7/20
 */
public class FindArraySamll {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{5, 2})));
  }

  public static int[] solution(int[] nums) {
    // 结果数组
    int[] results = new int[nums.length];
    // 注意，栈中的元素记录的是下标
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      final int current = nums[i];
      // 每个元素都向左遍历栈中的元素完成消除动作
      while (!stack.isEmpty() && nums[stack.peek()] > current) {
        // 消除的时候，值更大的需要从栈中消失，并且记录一下被谁消除了
        results[stack.pop()] = i;
      }
      // 记录入栈
      stack.push(i);
    }
    // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
    while (!stack.isEmpty()) {
      results[stack.peek()] = -1;
      stack.pop();
    }
    return results;
  }
}
