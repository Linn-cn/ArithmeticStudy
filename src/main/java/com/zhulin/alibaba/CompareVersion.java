package com.zhulin.alibaba;

/**
 * 说明：实现一个方法，用于比较两个版本号（version1、version2）
 * 如果version1 > version2，返回1；如果version1 < version2，返回-1，其他情况返回0
 * 版本号规则`x.y.z`，xyz均为大于等于0的整数，至少有x位
 * 示例：
 * compareVersion('0.1', '1.1.1'); // 返回-1
 * compareVersion('13.37', '1.2'); // 返回1
 * compareVersion('1.1', '1.1.0'); // 返回0
 */
public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.1", "1.1.0"));
        System.out.println(compareVersion("13.37", "1.2"));
        System.out.println(compareVersion("0.1", "1.1.1"));
    }


    /**
     * 先将字符串分割成数组
     * 然后一一比较，少的补0
     */
    public static int compareVersion(String str1, String str2) {
        String[] strs1 = str1.split("\\.");
        String[] strs2 = str2.split("\\.");
        int size = Math.max(strs1.length, strs2.length);
        for (int i = 0; i < size; i++) {
            int a = i >= strs1.length ? 0 : Integer.parseInt(strs1[i]);
            int b = i >= strs2.length ? 0 : Integer.parseInt(strs2[i]);
            if (a == b) continue;
            if (a > b) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
