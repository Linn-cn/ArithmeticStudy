package com.zhulin.demo;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Joseph
 * @description 约瑟夫
 * @create 2020-06-05 17:23
 **/
public class Joseph {

    public static void main(String[] args) {
        getAnswer(17);
    }

    private static void getAnswer(int n) {
        //用于判断某个数是否已经被剔除
        boolean[] isChoosed = new boolean[n];
        //记录答案数组
        int[] array = new int[n];
        //记录人数
        int num = n;
        //记录循环次数，最后的值就能知道你必须要数多少次，才能剩下一个人
        int count = 0;

        //如果人数只有一个人的时候，就结束循环
        while (num != 1) {
            //每一次的循环
            for (int i = 0; i < n; i++) {
                //如果这个位置没有被选择，也就是没有被删除，那么就给他赋值
                if (!isChoosed[i]) {
                    count++;
                    array[i] = count;
                    if (count % 3 == 0) {
                        isChoosed[i] = true;
                        num--;
                        System.out.println((i + 1) + "号被淘汰了");
                    }
                }
            }
        }

        //打印输出的结果
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "->->" + array[i]);
        }
    }

}
