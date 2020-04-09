package com.zhulin.weizhong;

import java.util.Scanner;

/**
 * 分礼物
 * 时间限制: C/C++语言2000MS;其他语言4000MS
 * 内存限制: C/C++语言131072KB;其他语言655360KB
 * 题目描述:
 * 有n位小朋友去小明家里拜年，小明准备了m份礼物。小明想把所有礼物平均分给每个小朋友，每
 * 个小朋友得到相同个数的礼物。但是m未必能被n整除，小明可以使用以下两种操作任意多次(两
 * 种操作可以同时使用)。
 * 1、 给其中-一个小朋友发红包，收到红包的小朋友会离开小明家。每个红包需要花费a元。
 * 2、购买个新礼物，每个礼物价值为b元。
 * 问小明最少花费多少元，才能使得所有礼物可以被剩下的小朋友平分。
 */
public class FenLiWu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            System.out.println(getResult(
                    Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[3])));
        }
    }

    private static int getResult(int n, int m, int a, int b) {
        if ((m % n) == 0) return 0;
        int result = 0;
        int temp = (a == b || a < b) ? a : b;
        if (m > n){
            // 礼物比人多
            while(m % n != 0){
                result += temp;
                if(a < b){      //让人走更合适
                    n--;
                }else{          //否则买新礼物更划算
                    m++;
                }
            }
        }else {
            // 礼物比人少
            for (int i = 0; i < n - m; i++) {
                result += temp;
            }
        }
        return result;
    }
}
