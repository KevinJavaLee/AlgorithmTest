package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName RotateImage
 * @Description Leetcode 48 旋转图像 中等难度 高频 看题解才有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/15/11:40
 * @Version 1.0
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate1(nums);


    }


    /**
     * 顺时针旋转矩阵
     * 可以理解为打印旋转矩阵
     * 螺转矩阵的打印点为(0,0) (1,1) (2,2)
     * 旋转90度之后(n-1,0) (n-2,1)
     * 辅助数组
     * 思路1：辅助数组
     * 思路2：翻转数组
     * @param matrix
     */
    public static void rotate(int[][] matrix) {


    }

    /**
     * 翻转数组思路
     * @param matrix
     */
    public static void rotate1(int[][] matrix) {

        int row = matrix.length;
        int col = row;

        //对行数据进行变化
        for (int i = 0; i < row/2; i++) {

            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - i][j];
                matrix[row - 1 - i][j] = tmp;
            }

        }

        //对对角线数据进行变换
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < i; j++) {

                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;

            }
        }


    }


}