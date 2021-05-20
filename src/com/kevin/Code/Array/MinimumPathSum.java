package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName MinimumPathSum
 * @Description Leetcode64 最小路径和 中等难度 中频 没思路
 * @Author Vinlee Xiao
 * @Date 2021/05/20/19:49
 * @Version 1.0
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1}};
        int i = minPathSum(nums);
        System.out.println(i);

    }

    /**
     * 动态规划：
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {


//        if (grid.length == 1 || grid[0].length == 1 ) {
//            return grid[0][0];
//        }
        //行和列数据
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        //如果i>0,j=0,求最小路径
        for (int i = 1; i < row ; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //如果i=0,j>0求最小路径
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        //如果i>0,j>0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(dp[i][j]+ " ");
//            }
//            System.out.println();
//        }
        return dp[row-1][col-1];
    }
}
