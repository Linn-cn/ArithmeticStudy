package com.zhulin.study.sort;

import java.util.Random;

/**
 * @author Linn-cn
 * @create 2020/10/19
 */
public class MergeSort2 {

    private static final int MAX = 20000000;
    private static final int[] Arr = new int[MAX];

    // 生成随机测试数据
    static {
        Random random = new Random();
        for (int i = 1; i <= MAX; i++) {
            Arr[i - 1] = random.nextInt(MAX);
        }
    }

    public static void main(String[] args) {
        // 统计耗时
        long start = System.currentTimeMillis();
        mergeSort(Arr, 0, Arr.length - 1);
        // System.out.println(Arrays.toString(Arr));
        long end = System.currentTimeMillis();
        System.out.println("归并排序千万级数据串行算法所需时间：" + (end - start) + "ms");
    }

    public static void mergeSort(int[] A, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        // 先排序左边
        mergeSort(A, low, mid);
        // 在排序右边
        mergeSort(A, mid + 1, high);
        merge(A, low, mid, high);
    }

    public static void merge(int[] A, int low, int mid, int high) {
        int[] B = new int[high - low + 1];
        int k = 0, i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            B[k++] = A[i] < A[j] ? A[i++] : A[j++];
        }
        // 将剩下的元素直接放进辅助数组
        while (i <= mid) B[k++] = A[i++];
        while (j <= high) B[k++] = A[j++];
        // 将辅助数组赋值给原数组
        for (i = low, k = 0; i <= high; i++, k++) {
            A[i] = B[k];
        }
    }
}
