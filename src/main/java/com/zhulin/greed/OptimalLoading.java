package com.zhulin.greed;

import java.util.*;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname OptimalLoading
 * @description 最优装载问题
 * 假设山洞中有n种宝物，每种宝物都有重量和价值，而车子的装载容量有限，怎么才能使车子运走的宝物价值最大呢？
 * 使用贪心算法
 * 第一步：求出每个宝物的性价比，并排序，每次取性价比最高的，从而达到全局最佳
 * @create 2020-04-12 13:41
 **/
class Three{
    int id;    // 宝物id
    double w; //每个宝物的重量
    double v; //每个宝物的价值
    double p; //每个宝物的性价比

    public Three(int id, double w, double v, double p) {
        this.id = id;
        this.w = w;
        this.v = v;
        this.p = p;
    }

    @Override
    public String toString() {
        return "Three{" +
                "w=" + w +
                ", v=" + v +
                ", p=" + p +
                '}';
    }
}
public class OptimalLoading {

    public static void main(String[] args) {
        // 可装载的重量
        double m = 5;
        List<Three> list = new ArrayList<>();
        list.add(new Three(1,2,8,4));
        list.add(new Three(2,8,20,2.5));
        list.add(new Three(3,5,15,3));
        list.add(new Three(4,3,15,5));
        list.add(new Three(5,4,16,4));
        list.add(new Three(6,6,18,3));
        list.add(new Three(7,10,25,2.5));
        double sum = 0;
        // 按性价比从大到小排列，每次取性价比最高的
        list.sort((u1, u2) -> Double.compare(u2.p, u1.p));
        System.out.println(list);
        for (Three three : list) {
            if (three.w <= m) {
                m = m - three.w;
                sum += three.v;
            } else {
                sum += (m * three.p);
            }
        }
        System.out.println("sum = " + sum);
    }
}
