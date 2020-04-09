package com.zhulin.leetcode.simple;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings2("TAUXXTAUXXTAUXXTAUXXTAUXX",
                "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"
        ));
    }

    /**
     * 错误实现
     * @return
     */
    public static String gcdOfStrings1(String str1, String str2) {
        String temp1 = str1.replace(str2,"");
        if ("".equals(temp1)) {
            return str2;
        }
        String temp2 = str2.replace(temp1,"");
        if ("".equals(temp2)){
            return temp1;
        }
        return "";
    }

    /**
     * 辗转相除法
     * 输入的两个字符串只有当(str1+str2).equals(str2+str1)时才能有解。
     * 找最大公约数可以看成对两个字符串的长度取最大公约数，然后从0截取最大公约数长度的串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings2(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

}
