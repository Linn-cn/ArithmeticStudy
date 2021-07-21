package com.zhulin.study;

import java.util.Stack;

/**
 * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。
 * 再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。
 * 这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 * <p>
 * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 * <p>
 * 当方向相对时，大鱼会吃掉小鱼；
 * <p>
 * 鱼的大小都不一样。
 * <p>
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 * <p>
 * 输出：3
 *
 * @author Zhu Lin
 * @date 2021/7/20
 */
public class FeedingFrenzy {
  public static void main(String[] args) {
    int[] Size = {4, 2, 5, 3, 1};
    int[] Dir = {1, 1, 0, 0, 0};
    System.out.println(solution(Size, Dir));
  }

  public static int solution(int[] Size, int[] Dir) {
    final int number = Size.length;
    // 如果鱼的数量小于等于1，那么直接返回鱼的数量
    if (number <= 1) return number;
    // 0表示鱼向左游
    final int left = 0;
    // 1表示鱼向右游泳
    final int right = 1;

    // 初始化栈，第一条鱼默认入栈
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < number; i++) {
      // 当前鱼的状况
      int currentFishDirection = Dir[i];
      int currentFishSize = Size[i];
      // 标记当前鱼是否被吃掉
      boolean hasEat = false;
      // 当前栈不为空，并且栈顶的鱼方向和当前鱼的方向不同
      // 注意：如果先入栈的往左，当前往右则无法相遇
      while ((!stack.isEmpty()) && Dir[stack.peek()] == right && currentFishDirection == left) {
        // 如果栈顶的鱼大就吃掉当前的鱼
        if (Size[stack.peek()] > currentFishSize) {
          hasEat = true;
          break;
        }
        // 如果栈顶的鱼小就被当前的鱼吃掉
        stack.pop();
      }
      // 如果新来的鱼，没有被吃掉，那么压入栈中。
      if (!hasEat) stack.push(i);
    }
    return stack.size();
  }
}
