package com.kevin.Code.DFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Project LeetCode
 * @ClassName NumberOfIslands
 * @Description Leetcode 200 岛屿的数量 dfs 中等难度 高频面试题 经典面试题 思路和最大岛屿思路相同 Leetcode 695
 * @Author Vinlee Xiao
 * @Date 2021/06/03/10:38
 * @Version 1.0
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}
        };
        int i = numIslands(grid);
        System.out.println(i);
    }

    /**
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    bfs(grid, i, j);
                }
            }
        }

        return sum;
    }

    /**
     * 求出岛屿的数量
     * @param grid
     * @param startX
     * @param startY
     * @return
     */
    public static int dfs(char[][] grid,int startX, int startY) {
        //递归终止条件
        if (startX < 0 || startX >= grid.length || startY < 0 || startY >= grid[0].length) {
            return 0;
        }


        int flag = 0;
        if (grid[startX][startY] == '1') {
            grid[startX][startY] = '0';
            flag = dfs(grid, startX - 1, startY) | dfs(grid, startX, startY - 1) |
                    dfs(grid, startX + 1, startY) | dfs(grid, startX, startY + 1)|1;

        }

        //shang
        return flag;
    }

    /**
     * 广度优先遍历
     *
     * @return
     */
    public static void bfs(char[][] grid, int i, int j) {
        //用于存储坐标
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{i, j});

        while (!deque.isEmpty()) {
            int[] index = deque.pollLast();
            i = index[0];
            j = index[1];

            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j]=='1') {
                grid[i][j] = '0';
                deque.addLast(new int[]{i-1,j});
                deque.addLast(new int[]{i,j-1});
                deque.addLast(new int[]{i+1,j});
                deque.addLast(new int[]{i,j+1});

            }
        }
    }
}
