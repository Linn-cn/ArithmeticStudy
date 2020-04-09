package com.zhulin.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname SparseArray
 * @description 稀疏数组
 * @create 2020-02-20 10:53
 **/
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子，1表示黑子，2表示白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][4] = 2;
        chessArr[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组:");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 将二维数组转稀疏数组的思想
        // 1.先遍历二维数组，得到非0数组的个数
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int j = 0; j < 11; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效数据为:" + sum);

        // 2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = (chessArr[0].length);
        sparseArray[0][2] = sum;

        // count用于记录是第几个有效数据
        for (int i = 0, count = 1, OneLength = chessArr.length; i < OneLength; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }

        // 3.将计算出来的稀疏数组保存到文件
        System.out.println("得到并存入文件的稀疏数组为:");
        try (FileOutputStream stream = new FileOutputStream(new File("D:\\sparseArray.txt"))){
            // 输出稀疏数组
            for (int[] row : sparseArray) {
                for (int data : row) {
                    stream.write((data + "\t").getBytes());
                    System.out.print(data + "\t");
                }
                stream.write("\r\n".getBytes());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4.读取文件中的稀疏数组
        List<String[]> list = new ArrayList<>();
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\sparseArray.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                lineCount ++;
                list.add(line.split("\t"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[][] readerSparseArrs = new int[lineCount][3];
        lineCount = 0;
        for (String[] datas : list) {
            readerSparseArrs[lineCount][0] = Integer.parseInt(datas[0]);
            readerSparseArrs[lineCount][1] = Integer.parseInt(datas[1]);
            readerSparseArrs[lineCount][2] = Integer.parseInt(datas[2]);
            lineCount++;
        }
        System.out.println("从文件中读取的稀疏数组：");
        for (int[] readerSparseArr : readerSparseArrs) {
            for (int data : readerSparseArr) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 5.从稀疏数组还原二维数组
        // 先读取第一行创建二维数组，在循环插入
        int rows = readerSparseArrs[0][0];
        int lines = readerSparseArrs[0][1];
        int[][] restoreArr = new int[rows][lines];
        for (int i = 1, length = readerSparseArrs.length; i < length; i++) {
            int row = readerSparseArrs[i][0];
            int line = readerSparseArrs[i][1];
            int value = readerSparseArrs[i][2];
            restoreArr[row][line] = value;
        }
        // 输出还原的二维数组
        for (int[] row : restoreArr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

    }
}
