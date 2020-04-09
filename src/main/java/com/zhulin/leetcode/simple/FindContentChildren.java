package com.zhulin.leetcode.simple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * <p>
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3], [1,1]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: [1,2], [1,2,3]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 **/
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        List<Integer> list = Arrays.stream(s).boxed().sorted().collect(Collectors.toList());
        int count = 0;
        for (int value : g) {
            if (list.get(list.size() - 1) < value) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                if (value <= list.get(i)) {
                    list.remove(i);
                    count++;
                    break;
                }
            }
            if (list.size() == 0) return count;
        }
        return count;
    }

    /**
     * 因为饥饿度最小的孩子最容易吃饱，所以先满足了这个孩子之后，我们再采取同样的策略，考虑剩下孩子里饥饿度最小的孩子，直到没有满足条件的饼干存在。
     * 简而言之，这里的贪心策略是，给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干。 至于具体实现，因为我们需要获得大小关系，一个便捷的方法就是把孩子和饼干分别排序。
     * 这样我们就可以从饥饿度最小的孩子和大小最小的饼干出发，计算有多少个对子可以满足条件。
     */
    public static int findContentChildren2(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        if (g[0] > s[s.length - 1]) return 0;
        int child = 0;
        int biscuit = 0;
        while (child < g.length && biscuit < s.length) {
            if (g[child] > s[s.length - 1]) break;
            if (g[child] <= s[biscuit]) {
                child++;
            }
            biscuit++;
        }
        return child;
    }

}
