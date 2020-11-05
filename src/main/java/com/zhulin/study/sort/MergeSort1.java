package com.zhulin.study.sort;

import java.util.Arrays;

/**
 * 归并排序，合并排序
 * @author Linn-cn
 * @date 2020/10/18
 */
public class MergeSort1 {
    public static void main(String[] args) {
        int[] A = {5, 4, 7, 9, 10, 21, 3};
        int[] temp = new int[A.length];
        mergeSort2(A, temp,0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 排序并合并数组
     *
     * @param A
     * @param low  下界
     * @param mid  中界
     * @param high 上界
     */
    public static void merge2(int[] A, int[] temp, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        // 每次将最小的值放进辅助数组
        while (i <= mid && j <= high) {
            temp[k++] = A[i] < A[j] ? A[i++] : A[j++];
        }
        // 将数组剩下元素直接放入辅助数组
        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= high) {
            temp[k++] = A[j++];
        }
        // 将辅助数组赋值给原数组
        for (i = low; i <= high; i++) {
            A[i] = temp[i];
        }
    }

    /**
     * 2.0版本，传入临时数组，避免每次需要创建临时数组进行操作
     * @param A 原数组
     * @param temp  临时数组
     * @param low   左边界
     * @param high  右边界
     * @author Linn-cn
     * @date 2020/9/6
     */
    public static void mergeSort2(int[] A, int[] temp, int low, int high) {
        if (low < high) {
            // 防止数值溢出
            int mid = low + (high - low) / 2;
            // 先分割左边
            mergeSort2(A, temp, low, mid);
            // 再分割右边
            mergeSort2(A, temp, mid + 1, high);
            // 排序
            merge2(A, temp, low, mid, high);
        }
    }



    /**
     * 排序并合并数组
     *
     * @param A
     * @param low  下界
     * @param mid  中界
     * @param high 上界
     */
    public static void merge(int[] A, int low, int mid, int high) {
        // 申请一个辅助数组
        int[] B = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        // 每次将最小的值放进辅助数组
        while (i <= mid && j <= high) {
            B[k++] = A[i] < A[j] ? A[i++] : A[j++];
        }
        // 将数组剩下元素直接放入辅助数组
        while (i <= mid) {
            B[k++] = A[i++];
        }
        while (j <= high) {
            B[k++] = A[j++];
        }
        // 将辅助数组赋值给原数组
        for (i = low, k = 0; i <= high; i++, k++) {
            A[i] = B[k];
        }
    }

    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            // 防止数值溢出
            int mid = low + (high - low) / 2;
            // 先分割左边
            mergeSort(A, low, mid);
            // 再分割右边
            mergeSort(A, mid + 1, high);
            // 排序
            merge(A, low, mid, high);
        }
    }
}
