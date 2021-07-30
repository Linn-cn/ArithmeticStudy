package com.zhulin.shuati.leetcode.difficulty;

import java.util.*;

/**
 * 239.题目：滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxSlidingWindow {
  // 单调队列
  private static Deque<Integer> deque = new ArrayDeque<>();

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println(Arrays.toString(maxSlidingWindow2(nums, 3)));
  }

  public static int[] maxSlidingWindow0(int[] nums, int k) {
    // 大顶堆
    PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
    int n = nums.length;
    if (n == 1) {
      return nums;
    }
    int[] result = new int[n - k + 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
      // 从优先队列中删除数组中当前位置的值
      if (queue.size() >= k) {
        queue.remove(nums[i - k]);
      }
      queue.offer(nums[i]);
      // 当前窗口中最大的值
      if (i >= k - 1) {
        result[index++] = queue.peek();
      }
    }
    return result;
  }

  /**
   * 作者：jyd
   * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
   * 来源：力扣（LeetCode）
   */
  public static int[] maxSlidingWindow1(int[] nums, int k) {
    if (nums.length == 0 || k == 0) return new int[0];
    Deque<Integer> deque = new LinkedList<>();
    int[] res = new int[nums.length - k + 1];
    for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
      if (i > 0 && deque.peekFirst() == nums[i - 1])
        deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
      while (!deque.isEmpty() && deque.peekLast() < nums[j])
        deque.removeLast(); // 保持 deque 递减
      deque.addLast(nums[j]);
      if (i >= 0)
        res[i] = deque.peekFirst();  // 记录窗口最大值
    }
    return res;
  }

  public static int[] maxSlidingWindow2(int[] nums, int k) {
    final ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      push(nums[i]);
      if (i < k - 1) {
        continue;
      }
      ans.add(deque.getFirst());
      pop(nums[i - k + 1]);
    }
    return ans.stream().mapToInt(Integer::valueOf).toArray();
  }

  private static void push(int val) {
    while ((!deque.isEmpty()) && deque.getLast() < val) {
      deque.removeLast();
    }
    deque.addLast(val);
  }

  private static void pop(int val) {
    if ((!deque.isEmpty()) && deque.getFirst() == val) {
      deque.removeFirst();
    }
  }
}
