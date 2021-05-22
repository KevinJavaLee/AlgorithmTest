package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName SpiralMatrixii
 * @Description Leetcode 50螺旋矩阵 中等难度 中频 螺旋矩阵变形 有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/22/10:54
 * @Version 1.0
 */
public class SpiralMatrixii {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * n表示矩阵几行几列
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int start = 0;
        int row = n;
        int col = n;
        int cnt = 1;

        while (row > 2 * start && col > 2 * start) {
            cnt = printMatrix(matrix,start,n,cnt);
            start++;
        }
        return matrix;
    }

    /**
     *
     * @param matrix
     * @param start
     * @param n
     * @param
     */
    public static int printMatrix(int[][] matrix, int start, int n,int cnt) {

        int endX = n - start - 1;
        int endY = n - start - 1;
        int count = cnt;
        //从左向右输出
        for (int i = start; i <= endX; i++) {
            matrix[start][i] = count;
            count++;
        }

        //从上向下输出 至少要有两行数据
        if (endY > start) {
            for (int i = start+1; i <= endY ; i++) {
                matrix[i][endX] = count;
                count++;
            }
        }

        //从右向左输出至少两行两列
        if (endX  > start && endY > start) {

            for (int i = endX-1; i >= start ; i--) {
                matrix[endX][i] = count;
                count++;
            }
        }

        //从下往上输出 至少3行2列
        if (endY - 1 > start && endX > start) {

            for (int i = endY - 1; i > start; i--) {
                matrix[i][start] = count;
                count++;
            }
        }

        return count;
    }
}
