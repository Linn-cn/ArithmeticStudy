package com.zhulin.leetcode.medium;

import java.util.*;

/**
 * 题目：每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, erc30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
//        int类型默认值为0
//        while (!stack.isEmpty()) {
//            result[stack.pop()] = 0;
//        }
        return result;
    }
}
