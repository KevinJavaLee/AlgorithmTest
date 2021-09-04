package com.kevin.Code.Bitwise;

/**
 * @author Vinlee Xiao
 * @Classname AddMethod
 * @Description 剑指 Offer 65. 不用加减乘除做加法 简单题 没啥思路
 * @Date 2021/9/4 8:45
 * @Version 1.0
 */
public class AddMethod {
    public static void main(String[] args) {
        int add = add(15, 7);
        System.out.println(add);
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {

        int num1 = a;
        int num2 = b;
        int sum = 0;
        int carry = 0;

        do {
            //1.不产生进位
            sum = num1 ^ num2;
//            System.out.println(sum);
            //2.
            carry = (num1 & num2) << 1;
//            System.out.println(carry);
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }
}
