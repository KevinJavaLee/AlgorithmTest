package com.kevin.Code.DP;

/**
 * @author Vinlee Xiao
 * @Classname UniqueBinarySearchTrees
 * @Description Leetcode 96. 不同的二叉搜索树 中等难度 动态规划 完全没有思路 难以理解
 * @Date 2021/9/21 20:48
 * @Version 1.0
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {

    }

    /**
     * 动态规划：大问题分解成为一个子问题 大问题的最优解依赖于局部最优解
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++) {

                dp[i] = dp[j - 1] * dp[i - j] + dp[i];
            }
        }

        return dp[n];
    }
}
