package com.kevin.Code.DP;

/**
 * @author Vinlee Xiao
 * @Classname UglyNumber
 * @Description 剑指 Offer 49. 丑数 同 Leetcode 264 中等难度  动态规划 最小堆没啥思路
 * @Date 2021/9/14 9:55
 * @Version 1.0
 */
public class UglyNumber {
    public static void main(String[] args) {
        int i = nthUglyNumber1(10);
        System.out.println(i);
    }


    /**
     * 方法1：直观法 效率不高  超过Leetcode时间限制
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {

        if (n == 1) {
            return 1;
        }

        int index = 1;
        int cnt = 2;
        int object = cnt;

        while (index < n) {


            if (isUglyNumber(cnt)) {
                object = cnt;
                index++;
            }
            cnt++;
        }


        return object;
    }

    public static boolean isUglyNumber(int number) {

        if (number == 1) {
            return true;
        }

        //怎么判断一个数是丑数
        //如果被三个数最后连续整除为1 则为丑数
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }


        return number == 1 ? true : false;

    }

    /**
     * 小根堆 动态规划
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];

        if (n == 1) {
            return 1;
        }

        int p1 = 1;
        int p2 = 1;
        int p3 = 1;

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            int num1 = dp[p1] * 2;
            int num2 = dp[p2] * 3;
            int num3 = dp[p3] * 5;

            dp[i] = Math.min(Math.min(num1, num2), num3);

            if (dp[i] == num1) {
                p1++;
            }

            if (dp[i] == num2) {
                p2++;
            }

            if (dp[i] == num3) {
                p3++;
            }
        }

        return dp[n];
    }
}
