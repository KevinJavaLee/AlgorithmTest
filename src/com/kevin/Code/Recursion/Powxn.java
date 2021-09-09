package com.kevin.Code.Recursion;

/**
 * @author Vinlee Xiao
 * @Classname Powxn
 * @Description 剑指 Offer 16. 数值的整数次方 同Leetcode 50 中等难度 细节问题
 * @Date 2021/9/9 10:03
 * @Version 1.0
 */
public class Powxn {
    public static void main(String[] args) {
        double v = myPow1(2., 7);
        System.out.println(v);
        System.out.println(3 & 1);
        System.out.println(7 >> 1);
    }

    /**
     * 思路1：时间超出限制
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        long num = n;

        if (x == 0) {
            return 0.0;
        }


        if (num == 1 || x == 1) {
            return x;
        }

        double res = 1.0;

        int flag = num < 0 ? -1 : 1;

        //边界值取负数会发生边界越界情况 -2147483648

        //如果n为负数，需要先对指数求绝对值，再反复求，求其倒数
        for (int i = 0; i < flag * num; i++) {
            res = x * res;
        }

        if (flag == -1) {
            res = 1.0 / res;
        }

        return res;

    }


    /**
     * 思路2：
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        long num = n;
        if (x == 0) {
            return 0.0;
        }


        if (num == 1 || x == 1) {
            return x;
        }

        if (num < 0) {
            x = 1.0 / x;
            num = -num;

        }
        double res = 1.0;

        //用与运算符来求是奇数还是偶数效率高于%
        //右移运算效率高于整除
        while (num > 0) {

            //如果num为奇数则x*res
            if ((num & 1) == 1) {
                res = res * x;
            }

            x = x * x;

            num = num >> 1;

        }

        return res;

    }


//    public static double cur(double x, long num) {
//
//        if (x == 0) {
//            return 0.0;
//        }
//
//        if (num == 1 ) {
//            return x;
//        }
//
//        //向左移动 缩小两倍
//        double result = cur(x, num >> 1);
//
//        result *= result;
//
//        if ((num & 1) == 1) {
//            result = x * result;
//        }
//
//
//        return result;
//    }


}
