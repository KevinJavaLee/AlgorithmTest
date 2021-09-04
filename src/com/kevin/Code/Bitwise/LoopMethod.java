package com.kevin.Code.Bitwise;

/**
 * @author Vinlee Xiao
 * @Classname LoopMethod
 * @Description 剑指 Offer 64. 求1+2+…+n 简单思路
 * @Date 2021/9/4 9:35
 * @Version 1.0
 */
public class LoopMethod {
    public static void main(String[] args) {
        int i = sumNums1(100);
        System.out.println(i);
    }


    /**
     * 1.高斯求和
     *
     * @param n
     * @return
     */
    public static int sumNums(int n) {


        return n * (n + 1) / 2;
    }


    public static int sumNums1(int n) {


        return n == 0 ? 0 : n + sumNums1(n - 1);
    }
}
