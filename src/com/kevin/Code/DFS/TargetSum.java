package com.kevin.Code.DFS;

/**
 * @Project LeetCode
 * @ClassName TargetSum
 * @Description Leetcode 494目标和 中等难度 低频  有思路
 * @Author Vinlee Xiao
 * @Date 2021/06/17/21:21
 * @Version 1.0
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;
        int i = findTargetSumWays(nums, target);
        System.out.println(i);
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {

        int result = dfs(nums, 0, 0, target);
        return result;
    }


    /**
     *
     * @param nums
     * @param index
     * @param sum
     * @param target
     *
     */
    public static int dfs(int[] nums, int index,int sum,int target ) {


        if (nums.length == index ) {

            if (sum == target) {
                return 1;
            }

            return 0;
        }

        int sum_subtract = sum - nums[index];

        int sum_add = sum + nums[index];

        return dfs(nums, index + 1, sum_add, target) + dfs(nums, index + 1, sum_subtract, target);
    }
}
