package com.zhulin.shuati.leetcode.simple;

/**
 * 题目：验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlalindromeDemo {

  public static void main(String[] args) {
    // 先去掉空格和标点符号，并且规范大小写
    // reverse and compare
    long begin = System.currentTimeMillis();
    String a = "A man, a plan, a canal: Panama";
    System.out.println(isPlalindrome(a));
    System.out.println(System.currentTimeMillis() - begin);
  }

  public static boolean isPlalindrome(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0, j = chars.length - 1; i < j; ) {
      if (!Character.isLetterOrDigit(chars[i])) i++;
      else if (!Character.isLetterOrDigit(chars[j])) j--;
      else if (Character.toLowerCase(chars[i++]) != Character.toLowerCase(chars[j--]))
        return false;
    }
    return true;
  }
}
