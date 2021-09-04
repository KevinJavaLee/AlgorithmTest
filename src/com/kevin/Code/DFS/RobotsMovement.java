package com.kevin.Code.DFS;

/**
 * @author Vinlee Xiao
 * @Classname RobotsMovement
 * @Description 剑指 Offer 13. 机器人的运动范围 中等难度
 * @Date 2021/9/4 10:14
 * @Version 1.0
 */
public class RobotsMovement {
    public static void main(String[] args) {
        int i = movingCount(3, 1, 0);
        System.out.println(i);
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];

        return dfs(m, n, k, visited, 0, 0);
    }


    /**
     * @param m
     * @param n
     * @param k
     * @param visited
     * @param startX
     * @param startY
     * @return
     */
    public static int dfs(int m, int n, int k, boolean[][] visited, int startX, int startY) {
        //递归中止条件
        if (startX < 0 || startX >= m || startY < 0 || startY >= n || (getBitSum(startX) + getBitSum(startY) > k) || visited[startX][startY]) {

            return 0;
        }


        //置该坐标为true 表示已经访问该点
        visited[startX][startY] = true;

        //上下左右
        return 1 + dfs(m, n, k, visited, startX - 1, startY) + dfs(m, n, k, visited, startX + 1, startY) + dfs(m, n, k, visited, startX, startY - 1) +
                dfs(m, n, k, visited, startX, startY + 1);
    }


    /**
     * @param num
     * @return
     */
    public static int getBitSum(int num) {
        int res = 0;
        while (num != 0) {
            int reminder = num % 10;
            res += reminder;
            num /= 10;
        }

        return res;
    }

}
