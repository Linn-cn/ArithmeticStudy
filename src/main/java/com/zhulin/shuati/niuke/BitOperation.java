package com.zhulin.shuati.niuke;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname BitOperation
 * @description 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @create 2020-06-08 16:11
 **/
public class BitOperation {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 计算a和b的无进位和，和进位
     * 如果进位不为0，则说明a+b的结果等于无进位和+进位，此时，把无进位和作为a，进位作为b，继续计算
     * 如果进位等于0， 说明此时a+b的结果就等于无进位和，返回无进位和即可。
     */
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            // 负数左移会在低位补1，所以转化为无符号整数
            int c = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = c;
        }
        return num1;
    }
}
