package com.zhulin.bishi.weizhong;

import java.util.Scanner;

/**
 * 回文游戏
 * 时间限制: C/C++语言1000MS;其他语言3000MS
 * 内存限制: C/C++语言65536KB;其他语言589824KB
 * 题目描述:
 * Cassidy和Eleanore是一对好朋友，她们经常会一起玩游戏。某-天她们玩了一一个回文游戏。
 * 游戏规则是这样的:
 * 给出一个仅包含小写字母的字符串S，在每一个人的回合中， 她们会进行两个操作:
 *      1.尝试重新排列这个字符串，如果可以把这个字符串排列成回文字符串，则立即获胜。
 *      2.否则，她们必须删掉字符串中的一个字符。
 * 已知，Cassidy先手， 在两个人都采取最佳策略的情况下，谁可以获胜。
 */
public class HuiWenYouXi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            String input = scanner.next();
            int result = getResult(input);
            if (result % 2 != 0) {
                System.out.println("Eleanore");
            } else {
                System.out.println("Cassidy");
            }
        }
        scanner.close();
    }

    public static int getResult(String s) {
        int[] arr = new int[57];
        for(char c : s.toCharArray()) {
            arr[c - 'A' - 1]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        int childLength = (count == 0 ? s.length() : (s.length() - count + 1));
        return s.length() - childLength;
    }
}
