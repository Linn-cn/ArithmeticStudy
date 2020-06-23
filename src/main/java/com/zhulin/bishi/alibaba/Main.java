package com.zhulin.bishi.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Model {
        // 血量
        public Integer H;
        // 攻击力
        public Integer A;
        // 防御力
        public Integer D;

        public Model(Integer h, Integer a, Integer d) {
            H = h;
            A = a;
            D = d;
        }

        public Integer getH() {
            return H;
        }

        public Model setH(Integer h) {
            H = h;
            return this;
        }

        public Integer getA() {
            return A;
        }

        public Model setA(Integer a) {
            A = a;
            return this;
        }

        public Integer getD() {
            return D;
        }

        public Model setD(Integer d) {
            D = d;
            return this;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 获得勇者属性
        String line = in.nextLine();
        String[] values = line.split(" ");
        Model model = new Model(Integer.valueOf(values[0]),
                Integer.valueOf(values[1]),
                Integer.valueOf(values[2]));
        // 怪物的数量
        int n = Integer.parseInt(values[3]);
        // 怪物集合
        List<Model> models = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            line = in.nextLine();
            values = line.split(" ");
            models.add(new Model(Integer.valueOf(values[0]),
                    Integer.valueOf(values[1]),
                    Integer.valueOf(values[2])));
        }
        // 击败的怪物数量
        int sum = 0;
        for (int i = 0; i < models.size(); i++) {
            // 攻击
            process(model, models.get(i));
            if (model.getH() < 0) {
                break;
            }
            // 最优策略
            if (i < models.size() - 1) {
                condition(model, select(model, models.get(i + 1)));
            }
            sum++;
        }
        System.out.println(sum);
    }

    /**
     * 选择策略....没搞懂
     *
     * @param model 勇者
     * @param bad   怪兽
     */
    public static int select(Model model, Model bad) {
        // 如果勇者的攻击力可以秒杀怪物，就选择加血
        if ((model.getA() - bad.getD()) > bad.getH()) {
            return 1;
        }
        if ((model.getA() + 10 - bad.getD()) > bad.getH()) {
            return 2;
        }
        return 3;
    }

    /**
     * 攻击
     *
     * @param model 勇者
     * @param bad   怪兽
     */
    public static void process(Model model, Model bad) {
        boolean flag = true;
        while (bad.getH() > 0) {
            if (flag) {
                bad.setH(bad.getH() - Math.max(model.getA() - bad.getD(), 1));
                flag = false;
            } else {
                model.setH(model.getH() - Math.max(bad.getA() - model.getD(), 1));
                flag = true;
            }
        }
    }

    /**
     * 1.血量奖励 +1000
     * 2.攻击力 +10
     * 3.防御力 +10
     *
     * @param model  勇者对象
     * @param number 选择的奖励
     */
    public static void condition(Model model, Integer number) {
        if (number.equals(1)) {
            model.setH(model.getH() + 1000);
        }
        if (number.equals(2)) {
            model.setA(model.getA() + 10);
        }
        if (number.equals(3)) {
            model.setD(model.getD() + 10);
        }
    }
}
