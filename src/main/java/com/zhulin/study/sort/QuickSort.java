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
        int[] nums = {6, 4, 1, 3, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    /**
     * 标准的partition的写法
     * @param nums
     * @param low
     * @param high
     * @author Linn-cn
     * @create 2020/8/13
     * @return int
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
     * 如果我们不考虑空间消耗的话，partition() 分区函数可以写得非常简单。
     * 我们申请两个临时数组 X 和 Y，遍历 A[p…r]，将小于 pivot 的元素都拷贝到临时数组 X，
     * 将大于 pivot 的元素都拷贝到临时数组 Y，最后再将数组 X 和数组 Y 中数据顺序拷贝到 A[p…r]。
     *
     * 这样快排就不是原地排序算法了
     * @param nums
     * @param low
     * @param high
     * @author Linn-cn
     * @create 2020/8/13
     * @return int
     */
    public static int paratiton1(int[] nums, int low, int high){
        int pivotkey = nums[low];
        int[] lows = new int[high - low];
        int[] highs = new int[high - low];
        for (; low < high && nums[high] > pivotkey; low++) {

        }

        return 0;
    }

}
