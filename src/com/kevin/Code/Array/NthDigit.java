package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname NthDigit
 * @Description 剑指Offer 44   Leetcode 400. 第 N 位数字 中等难度 完全没有半点思路
 * @Date 2021/9/10 15:27
 * @Version 1.0
 */
public class NthDigit {
    public static void main(String[] args) {
        int i = findNthDigit(1000000000);
        System.out.println(i);
    }

    /**
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {

        if (n == 0) {
            return 0;
        }

        long num = n;


        //数字的位数
        int digits = 1;
        while (true) {

            //得到每个位数的数个数
            long total = getDigitNum(digits);
//            System.out.println("total_"+total);
            long res = total * digits;
//            System.out.println(res);
            if (num < res) {
                return getOrderNum(num, digits);
            }
//            System.out.println("total:"+total * digits);
            num = num - (int) res;
//            System.out.println("num"+num);
            digits++;
        }

    }


    /**
     * 根据数字的位数 返回每个位数的数字 共有多少个
     *
     * @param digits
     * @return
     */
    public static long getDigitNum(int digits) {

        if (digits == 1) {
            return 10;
        }

        return (long) Math.pow(10, digits - 1) * 9;

    }


    public static long getDigitStartNum(int digits) {
        if (digits == 1) {
            return 0;
        }

        return (long) Math.pow(10, digits - 1);
    }


    /**
     * @param num
     * @param digit
     * @return
     */
    public static int getOrderNum(long num, int digit) {
//        System.out.println(num);
//        System.out.println(digit);

        long startNum = getDigitStartNum(digit) + num / digit;
//        System.out.println(startNum);
        long startIndex = digit - num % digit;
//        System.out.println(startIndex);
        long res = startNum % 10;
        //余数 0 对应其中第1 位数字 所以 1 对应第i位数字
        for (int i = 1; i < startIndex; i++) {
            startNum = startNum / 10;
            res = startNum % 10;
//            System.out.println(startNum);
        }
        return (int) res;
    }
}
