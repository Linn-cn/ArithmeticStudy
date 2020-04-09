package com.zhulin.demo;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname Test2
 * @description
 * @create 2020-03-12 16:24
 **/
public class Test2 {



    public static void main(String[] args) {
//        int nums[] = {2,2,2,2,3};
//        int n = 3;
//        System.out.println(averaging(nums,n));
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] strings = scan.nextLine().split(" ");
            for(int i = strings.length - 1; i >= 0; i--){
                System.out.println(strings[i]);
                System.out.println(" ");
            }
        }
    }

    /**
     * double arithAverageOfArray2(int a[],int n) {
     *     if(n==1) return a[0];
     *     else return a[n-1]/n+ ( arithAverageOfArray2(a,n-1)*(n-1) )/n;
     * }
     * @param nums
     * @return
     */

    public static double averaging(int[] nums,int n){
        if(n==1) {
            return nums[0];
        }else {
            return nums[n-1]/n + (averaging(nums,n-1)*(n-1))/n;
        }
    }

}
