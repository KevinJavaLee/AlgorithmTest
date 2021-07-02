package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName SpiralOrderArray
 * @Description 剑指 Offer 29. 顺时针打印矩阵 简单 看书有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/08/16:28
 * @Version 1.0
 */
public class SpiralOrderArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] order = spiralOrder(matrix);
        for (int i : order) {
            System.out.print(i + " ");
        }
    }

    /**
     * 参考剑指offer
     * [[1,2,3,4],
     * [5,6,7,8],
     * [9,10,11,12]]  [1,2,3,4,8,12,11,10,9,5,6,7]
     * [[1,2,3],
     * [4,5,6],
     * [7,8,9]] [1,2,3,6,9,8,7,4,5]
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //左上角开始地方
        List<Integer> list = new ArrayList();
        int start = 0;
        while (row > 2 * start && col > 2 * start) {
            List<Integer> arrList= printMatrix(matrix, start, col, row);
            list.addAll(arrList);
            start++;

        }

        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        return array;
    }

    /**
     *
     * @param mat
     * @param start
     * @param col
     * @param row
     * @return
     */
    public static List<Integer> printMatrix(int[][]mat, int start, int col, int row) {
        int endX = col - start - 1;
        int endY = row - start - 1;
        ArrayList<Integer> list = new ArrayList<>();

        //从左往右打印矩阵
        for (int i = start; i <= endX; i++) {
            list.add(mat[start][i]);
        }

        //从上往下打印 至少应该右两行数据
        if (endY > start) {
            for (int i = start + 1; i <=endY; i++) {
                list.add(mat[i][endX]);
            }
        }

        //从右往左打印 至少满足两行两列的数据
        if (endX > start && endY > start) {

            for (int i = endX-1; i >= start; i--) {
                list.add(mat[endY][i]);
            }
        }

        //从下往上打印矩阵 至少满足三行两列
        if (endX > start && endY > start + 1) {
            for (int i = endY-1; i > start; i--) {
                list.add(mat[i][start]);
            }
        }


        return list;
    }
}
