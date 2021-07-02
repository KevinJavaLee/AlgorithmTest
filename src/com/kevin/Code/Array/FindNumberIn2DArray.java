package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName FindNumberIn2DArray
 * @Description 剑指 Offer 04. 二维数组中的查找 中等
 * @Author Vinlee Xiao
 * @Date 2021/05/09/11:32
 * @Version 1.0
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix= new int[][]{{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };

        boolean b = findNumberIn2DArray(matrix, 20);
        System.out.println(b);
    }

    /**
     * 原始做法：排序数组二分法
     *
     * @param matrix
     * @param target
     * @return
     */
    public  static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            boolean flag = binarySearch(matrix[i], target);
            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
        }

        return false;
    }
}
