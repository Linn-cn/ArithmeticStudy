package com.zhulin.bishi.alibaba;

import java.util.Arrays;

/**
 * 判断数组的排序
 * 说明：实现一个方法，数组为升序返回1，数组为降序返回-1，乱序返回0
 * 示例：
 *   isSorted([0, 1, 2, 2]); // 1
 *   isSorted([4, 3, 2]); // -1
 *   isSorted([4, 3, 5]); // 0
 */
public class ArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2};
//        int[] nums = {4, 3, 2};
//        int[] nums = {4, 3, 5};

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            isSorted2(nums);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    /**
     * 思路1:如果小于就说明接下来的必须要全部是小于，用true表示，大于则是false
     * 然后根据boolean去判断接下来的是全部大于还是小于
     * @param nums
     * @return
     */
    public static int isSorted1(int[] nums) {
        int index = 0, i = 1;
        boolean status = nums[index++] < nums[i++];  // 如果小于就说明接下来的必须要全部是小于，用true表示，大于则是false
        for (; i < nums.length; i++) {
            if (status) {
                // 只要有一个不对，说明无序
                if (nums[index] > nums[i]) {
                    return 0;
                }
            } else {
                if (nums[index] < nums[i]) {
                    return 0;
                }
            }
            index++;
        }
        if (i == nums.length) {
            return status ? 1 : -1;
        } else {
            return 0;
        }
    }

    /**
     * 思路2: 先升序，升序之后还相等，说明是升序的
     * 否则逆序比较，逆序比较全通过说明是逆序的，中间只要有一个不对说明就是无序的
     * @param nums
     * @return
     */
    public static int isSorted2(int[] nums) {
        int[] temps = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temps);
        if (Arrays.equals(nums,temps)){
            return 1;
        }else {
            for (int i = temps.length - 1,j = 0; i >= 0; i--,j++) {
                if (temps[i] != nums[j]){
                    return 0;
                }
            }
        }
        return -1;
    }
}
