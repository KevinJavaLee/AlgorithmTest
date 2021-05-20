package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName UniquePaths
 * @Description Leetcode 62 不同路径 中等难度 经典动态规划 回溯 经典题目 和最小路径和优点类似
 * @Author Vinlee Xiao
 * @Date 2021/05/20/19:54
 * @Version 1.0
 */
public class UniquePaths {
    public static void main(String[] args) {
        int i = uniquePaths(3, 2);
        System.out.println(i);
    }

    /**
     *  动态规划：
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        //定义一个数组用于记录到该坐标有几种路线
        int[][] dp = new int[m][n];

        //当i=0,j>1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
