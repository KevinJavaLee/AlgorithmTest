package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName FindMinimumInRotatedSortedarray
 * @Description Leetcode 153. 寻找旋转排序数组中的最小值 中等难度 中频 有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/16/16:15
 * @Version 1.0
 */
public class FindMinimumInRotatedSortedarray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }


    /**
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {

        int min = nums[0];
        int index = 0;
        int len = nums.length;


        for (int i = 0; i < len-1; i++) {
            index++;
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }


        return nums[index] < min ? nums[index] : min;
    }
}
