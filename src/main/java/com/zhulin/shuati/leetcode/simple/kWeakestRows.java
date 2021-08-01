package com.zhulin.shuati.leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 题目：1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 * <p>
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 * 通过次数23,579提交次数33,746
 *
 * @author Zhu Lin
 * @date 2021/8/1
 */
public class kWeakestRows {
  public int[] kWeakestRows(int[][] mat, int k) {
    final List<int[]> power = binarySearch(mat);
    final PriorityQueue<int[]> priorityQueue = smallRootPile(power);
    int[] ans = new int[k];
    for (int i = 0; i < k; ++i) {
      ans[i] = priorityQueue.poll()[1];
    }
    return ans;
  }

  public List<int[]> binarySearch(int[][] mat) {
    int length = mat.length;
    int n = mat[0].length;
    final ArrayList<int[]> ans = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      int left = 0, right = n - 1, pos = -1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (mat[i][mid] == 0) {
          right = mid - 1;
        } else {
          pos = mid;
          left = mid + 1;
        }
      }
      ans.add(new int[]{pos + 1, i});
    }
    return ans;
  }

  public PriorityQueue<int[]> smallRootPile(List<int[]> power) {
    final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      } else {
        return a[1] - b[1];
      }
    });
    for (int[] pair : power) {
      priorityQueue.offer(pair);
    }
    return priorityQueue;
  }
}
