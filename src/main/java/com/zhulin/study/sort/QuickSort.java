package com.zhulin.study.sort;

import java.util.Arrays;

/**
 * @author Linn-cn
 * @description 快速排序
 * 快排的思想是这样的：
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * <p>
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，
 * 前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 * <p>
 * <p>
 * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，
 * 直到区间缩小为 1，就说明所有的数据都有序了。
 * @create 2020/08/13
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {4, 9, 7, 2, 5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    // public static int quickSort(int[] nums, int low, int high, int k) {
    //   int pivot = partition2(nums, low, high);
    //   if (pivot + 1 == k) {
    //     return nums[pivot];
    //   }
    //   if (pivot + 1 > k) {
    //     return quickSort(nums, low, pivot - 1, k);
    //   } else {
    //     return quickSort(nums, pivot + 1, high, k);
    //   }
    // }

    /**
     * 标准的partition的写法
     *
     * @param nums
     * @param low
     * @param high
     * @return int
     * @author Linn-cn
     * @create 2020/8/13
     */
    private static int partition(int[] nums, int low, int high) {
        int pivotkey = nums[low];
        while (low < high) {
            while (high > low && nums[high] >= pivotkey) {
                high--;
            }
            nums[low] = nums[high];
            while (high > low && nums[low] <= pivotkey) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivotkey;
        return low;
    }

    /**
     * 这里的处理有点类似选择排序。我们通过游标 i 把 A[p…r-1] 分成两部分。A[p…i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i…r-1] 是“未处理区间”。
     * 我们每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
     */
    private static int partition2(int[] nums, int low, int high) {
        int pivotkey = nums[high];
        int i = low;
        for (int j = i; j < high; j++) {
            if (nums[j] < pivotkey) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        nums[high] = nums[i];
        nums[i] = pivotkey;
        return i;
    }

}
