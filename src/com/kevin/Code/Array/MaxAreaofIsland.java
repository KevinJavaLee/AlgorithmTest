package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName MaxAreaofIsland
 * @Description Leetcode 695岛屿的最大面积 深度优先搜索  回溯法 经典题目 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/05/22/11:59
 * @Version 1.0
 */
public class MaxAreaofIsland {
    public static void main(String[] args) {
        int[][] nums =new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
                                            };

        int i = maxAreaOfIsland(nums);
        System.out.println(i);
    }

    /**
     * 深度优先搜素：
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        //用于记录每一次的最大值
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] ==1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }

            }

        }

        return ans;

    }

    /**
     * 思路：1.从陆地坐标开始向四个方向遍历，得出面积
     *
     * dfs深度优先搜索遍历
     *
     * @return
     */
    public static int dfs(int[][] grid, int i, int j) {

        //终止条件
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        //从4个方向开始递归

        return 1+dfs(grid,i+1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1)+dfs(grid,i-1,j);
    }


}
