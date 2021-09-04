package com.kevin.Code.DP;

/**
 * @author Vinlee Xiao
 * @Classname IntegerBreak
 * @Description 剑指Offer14 同 Leetcode 343 整数拆分 中等难度 动态规划 没啥思路
 * @Date 2021/9/4 15:35
 * @Version 1.0
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int i = integerBreak(120);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {

        int[] dp = new int[n + 1];
//        final int MOD = 1000000007;

        for (int i = 2; i <= n; i++) {

            int currentMax = 0;
            for (int j = 1; j <= i / 2; j++) {
                currentMax = Math.max(currentMax, Math.max(j * (i - j), j * (dp[i - j])));
            }
            dp[i] = currentMax;
        }

        return dp[n];
    }

}
