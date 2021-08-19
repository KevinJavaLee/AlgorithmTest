package com.kevin.Code.String;

import java.math.BigInteger;

/**
 * @author Vinlee Xiao
 * @Classname StringToInt
 * @Description 剑指Offer 67把字符串转换成整数 同Leetcode8 中等难度 细节题
 * @Date 2021/8/19 10:55
 * @Version 1.0
 */
public class StringToInt {
    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
        int i = strToInt("2147483646");
        System.out.println(i);
    }

    /**
     * 重要的时如何处理越界问题
     *
     * @param str
     * @return
     */
    public static int strToInt(String str) {

        //1.去除前后空格
        String s = str.trim();
        int size = s.length();
        int border = Integer.MAX_VALUE / 10;
        int reminder = Integer.MAX_VALUE % 10;
        //定义符号
        int sign = 1;
        int startIndex = 0;
        if (size == 0) {
            return 0;
        } else if (s.charAt(0) == '+' || s.charAt(0) == '-' || (s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
            if (s.charAt(0) == '-') {
                sign = -1;
                startIndex = 1;
            } else if (s.charAt(0) == '+') {
                startIndex = 1;
            }

            int num = 0;

            while (startIndex < size) {
                if (s.charAt(startIndex) < '0' || s.charAt(startIndex) > '9') {
                    break;
                }

                if (num > border || (num == border) && (s.charAt(startIndex) - '0' > reminder)) {

                    return sign == 1 ? border * 10 + reminder : ((border) * 10 + reminder + 1) * sign;


                }

                num = num * 10 + s.charAt(startIndex) - '0';
                startIndex++;
            }
            return sign == 1 ? num : sign * num;

        } else {
            return 0;
        }


    }
}
