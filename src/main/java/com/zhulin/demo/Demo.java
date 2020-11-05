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
        ArrayList<String> list = new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
        }};

        for (int i = 0, m = list.size(); i < m; i++) {
            String str = list.get(i);
            if ("a".equals(str)){
                list.remove(i);
            }
        }
        System.out.println(list.size());
    }
}
