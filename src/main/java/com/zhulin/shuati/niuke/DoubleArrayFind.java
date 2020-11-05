package com.zhulin.shuati.niuke;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author Linn-cn
 * @create 2020/10/11
 */
public class DoubleArrayFind {

    public static void main(String[] args) {
        int[][] nums = {{}};
        System.out.println(Find(6, nums));
    }

    public static boolean Find(int target, int [][] array) {
        for (int i = array.length - 1; i >= 0 && array.length > 0 && array[i].length > 0; i--) {
            if (array[i][array[i].length - 1] < target) {
                continue;
            }
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
