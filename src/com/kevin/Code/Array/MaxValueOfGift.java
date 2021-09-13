package com.kevin.Code.Array;

import java.util.ArrayList;

/**
 * @author Vinlee Xiao
 * @Classname MaxValueOfGift
 * @Description 剑指 Offer 47. 礼物的最大价值 动态规划题 值得再做
 * @Date 2021/9/13 17:15
 * @Version 1.0
 */
public class MaxValueOfGift {

    public static void main(String[] args) {

        int[][] grip = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = maxValue1(grip);
        System.out.println(i);


    }

    /**
     * 深度优先遍历 超出时间限制
     *
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {

        if (grid.length == 1 && grid[0].length == 1) {

            return grid[0][0];
        }

        int res = dfs(grid, 0, 0);
        return res;
    }


    public static int dfs(int[][] grid, int startX, int startY) {

//        System.out.print(startX+"-");
//        System.out.println(startY);
//        System.out.println("-----------");
//

        if (startX >= grid.length || startY >= grid[0].length) {

            return -1;
        }

        if (startX == grid.length - 1 && startY == grid[0].length - 1) {

            return grid[startX][startY];
        }

        int a = 0;
        int b = 0;
        a = dfs(grid, startX, startY + 1);
        b = dfs(grid, startX + 1, startY);


        if (a == -1 && b == -1) {
            return -1;
        }

//        System.out.println(grid[startX][startY]);
        return Math.max(a, b) + grid[startX][startY];

    }

    /**
     * 动态规划处理套路
     *
     * @param grid
     * @return
     */
    public static int maxValue1(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (row == 1 && col == 1) {
            return grid[0][0];
        }

        int[][] maxGift = new int[grid.length][grid[0].length];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                int a = 0;
                int b = 0;
                if (i > 0) {
                    a = maxGift[i - 1][j];
                }

                if (j > 0) {
                    b = maxGift[i][j - 1];
                }

                maxGift[i][j] = Math.max(a, b) + grid[i][j];
            }
        }


        return maxGift[row - 1][col - 1];
    }

}
