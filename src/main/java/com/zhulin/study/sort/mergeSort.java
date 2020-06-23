package com.zhulin.study.sort;

import java.util.Arrays;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname mergeSort
 * @description 归并排序，合并排序
 * @create 2020-06-06 17:07
 **/
public class mergeSort {
    public static void main(String[] args) {
        int[] A = {5, 4, 7, 9, 10, 21, 3};
        mergeSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 合并数组
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
