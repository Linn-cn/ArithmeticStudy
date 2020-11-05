package com.zhulin.study.sort;

/**
 * ForkJoinPool实现归并排序
 *
 * @author Linn-cn
 * @create 2020/11/03
 */

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeSort {
    private static final int MAX = 100;
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
        ForkJoinPool pool = new ForkJoinPool();
        MergeSortTask task = new MergeSortTask(Arr);
        ForkJoinTask<int[]> taskResult = pool.submit(task);

        try {
            System.out.println(Arrays.toString(taskResult.get()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("归并排序千万级数据并行算法所需时间：" + (end - start) + "ms");
    }

    static class MergeSortTask extends RecursiveTask<int[]> {

        private int[] source;

        public MergeSortTask(int[] source) {
            this.source = source;
        }

        @Override
        protected int[] compute() {
            int length = source.length;
            // 如果条件成立，说明任务中要进行排序的集合还不够小
            if (length > 2) {
                int mid = length / 2;

                // 拆分成两个子任务
                MergeSortTask task1 = new MergeSortTask(Arrays.copyOf(source, mid));
                task1.fork();

                MergeSortTask task2 = new MergeSortTask(Arrays.copyOfRange(source, mid, length));
                task2.fork();

                // 将两个有序的数组，合并成一个有序的数组
                int[] result1 = task1.join();
                int[] result2 = task2.join();
                return joinInts(result1, result2);
            }
            // 集合中只有一个或者两个元素，可以进行这两个元素的比较排序了
            else {
                if (length == 1 || source[0] < source[1]) {
                    return source;
                } else {
                    int temp = source[0];
                    source[0] = source[1];
                    source[1] = temp;
                    return source;
                }
            }
        }

        /**
         * 将两个有序数组合并起来
         * @author Linn-cn
         * @date 2020/11/3
         */
        private int[] joinInts(int[] arr1, int[] arr2) {
            int left = 0, right = 0, i = 0;
            int[] mergeArr = new int[arr1.length + arr2.length];
            if (mergeArr.length == 0) {
                return null;
            }
            // 每次将最小的值放进辅助数组
            while (left < arr1.length && right < arr2.length) {
                mergeArr[i++] = arr1[left] < arr2[right] ? arr1[left++] : arr2[right++];
            }
            // 将数组剩下元素直接放入辅助数组
            while (left < arr1.length) {
                mergeArr[i++] = arr1[left++];
            }
            while (right < arr2.length) {
                mergeArr[i++] = arr2[right++];
            }
            return mergeArr;
        }
    }
}