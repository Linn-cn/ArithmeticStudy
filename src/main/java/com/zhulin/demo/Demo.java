package com.zhulin.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Demo
 * @description
 * @create 2020-03-29 15:17
 **/
public class Demo {
    public static void main(String[] args) {
        Insert(2563);
    }

    static List<Integer> list = new ArrayList<>();

    public static void Insert(Integer num) {
        int i = 0;
        while(num > 0){
            i++;
            list.add(num%10);
            num = num/10;
        }
        System.out.println(GetMedian(i));
    }

    public static Double GetMedian(int i) {
        int temp = i / 2;
        if(i%2 == 0){
            return (double)((list.get(temp) * 10) + list.get(temp - 1));
        }
        return (double)list.get(temp);
    }
}
