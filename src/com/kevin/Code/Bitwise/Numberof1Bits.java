package com.kevin.Code.Bitwise;

/**
 * @author Vinlee Xiao
 * @Classname Numberof1Bits
 * @Description 剑指Offer15 同 Leetcode 191 位1的个数 简单题 考查点位运算 非常经典
 * @Date 2021/9/3 10:30
 * @Version 1.0
 */
public class Numberof1Bits {
    public static void main(String[] args) {
        int i = hammingWeight1(128);
        System.out.println(i);
        System.out.println();
    }

    /**
     * 方案：将n-1再与n作与运算 将最右边的1变为0
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {

        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }

    /**
     * 避免负数运算问题
     *
     * @param n
     * @return
     */
    public static int hammingWeight1(int n) {

        //将flag不断的向左移动
        int cnt = 0;
        int count = 0;
        int flag = 1;
        while (flag != 0) {

            if ((n & flag) != 0) {

                cnt++;
            }

            flag = flag << 1;
            count++;
        }
//        System.out.println(count);
        return cnt;
    }
}
