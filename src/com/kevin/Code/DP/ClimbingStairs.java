package com.kevin.Code.DP;

/**
 * @author Vinlee Xiao
 * @Classname ClimbingStairs
 * @Description 剑指 Offer 10- II. 青蛙跳台阶问题 同 Leetcode 70 简单题 斐波那契数列的应用
 * @Date 2021/9/4 14:40
 * @Version 1.0
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int i = climbStairs(7);
        System.out.println(i);
    }

    /**
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        final int MOD = 1000000007;

        int num1 = 1;
        int num2 = 1;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            int tmp = num1 + num2;
            num1 = num2;
            num2 = tmp % MOD;
        }

        return num2;
    }
}
