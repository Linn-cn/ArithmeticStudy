package com.zhulin.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname PlalindromeDemo
 * @description 回文数
 * @create 2020-03-04 21:20
 **/
public class PlalindromeDemo {
    static Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
    public static void main(String[] args) {
        // 先去掉空格和标点符号，并且规范大小写
        // reverse and compare
        long begin = System.currentTimeMillis();
        String a = "A man, a plan, a canal: Panama";
        for (int i = 0; i < 10000; i++) {
            new PlalindromeDemo().isPlalindrome(a);
        }
        System.out.println(System.currentTimeMillis()-begin);
    }

    public boolean isPlalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;
//        String filter = _filterNonNumberAndChar(s);
//        return _reverse(filter).equalsIgnoreCase(filter);
    }

    private String _reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String _filterNonNumberAndChar(String s) {
        return pattern.matcher(s).replaceAll("");
//        return s.replaceAll("[^A-Za-z0-9]","");
    }
}
