package com.zhulin.demo;

import java.util.Scanner;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Test3
 * @description
 * @create 2020-03-27 14:31
 **/
public class Test3 {
    static int SumPeach(int day) {
        if(day==1)
            return 1;
        else
            return (SumPeach(day-1)+1)*2;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入天数");
        int day=scanner.nextInt();
        System.out.println("第"+day+"天有"+SumPeach(11-day)+"个桃子");
    }
}
