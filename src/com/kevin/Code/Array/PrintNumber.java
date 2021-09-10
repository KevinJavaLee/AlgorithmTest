package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname PrintNumber
 * @Description 剑指 Offer 17. 打印从1到最大的n位数 简单题  全排列解决
 * @Date 2021/9/9 11:46
 * @Version 1.0
 */
public class PrintNumber {
    public static void main(String[] args) {
        int n = 2;
        char[] ch = new char[2];

        while (!printNumbers(ch, n)) {
            printNum(ch);
        }

    }

    /**
     * @param n
     * @return
     */
    public static boolean printNumbers(char[] ch, int n) {


        int len = ch.length;
        int m = '0';


        boolean isOverflow = false;
        int carry = 0;
        for (int i = len - 1; i > 0; i--) {

            int sum = ch[i] - '0' + carry;
            System.out.println(carry);
//            System.out.println("sum"+sum);
//            System.out.println(carry);
            if (i == len - 1) {
                sum++;
            }
            System.out.println(sum);
            if (sum >= 10) {

                if (i == 0) {
                    isOverflow = true;
                } else {
                    sum = sum - 10;
                    carry = 1;
                    System.out.println("---");
                    ch[i] = (char) (sum + m);
                }

            } else {
                ch[i] = (char) (sum + m);
//                System.out.println(String.valueOf(ch));
                break;
            }


        }

        return isOverflow;
    }


    public static void printNumbers1(int n) {

        char[] ch = new char[n];
        int len = ch.length;
//        char c1 = '0';
        int n1 = '0';
        for (int i = 0; i < 10; i++) {
            //
            ch[0] = (char) (n1 + i);
//            System.out.println(ch[0]);
            helper(ch, len, 0);

        }

    }

    public static void helper(char[] ch, int len, int index) {

        if (index == len - 1) {
            printNum(ch);
            return;
        }
        int n1 = '0';
        for (int i = 0; i < 10; i++) {
            ch[index + 1] = (char) (n1 + i);
            helper(ch, len, index + 1);
        }
    }

    /**
     * 用于打印字符中的数字
     *
     * @param c
     */
    public static void printNum(char[] c) {

//        System.out.println(String.valueOf(c));
//        boolean isZero = true;
//
//        for (int i = 0; i < c.length; i++) {
//
//            if (isZero && c[i] != '0') {
//                isZero = false;
//            }
//
//            if (!isZero) {
//                System.out.print(c[i]);
//
//            }
//        }
//        System.out.println();
    }
}
