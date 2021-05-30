package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName RotateArray
 * @Description Leetcode 189旋转数组 中等难度 技巧型题目 翻转数组 可以重做
 * @Author Vinlee Xiao
 * @Date 2021/05/30/15:01
 * @Version 1.0
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate1(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     *  数组翻转容易理解
     *  环状替换 官方题解
     *  技巧型题目
     *  你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {


        int len = nums.length;
         k = k % len;
        if (len == 1) {
            return;
        }

        //三次翻转
        reverse(nums, 0, len - 1);

        //第二次翻转
        reverse(nums, 0, k - 1);
        //第三次翻转
        reverse(nums, k, len - 1);

        return;
    }

    /**
     * 翻转数组
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 环形替换 解法非常新异
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int index = 0;
        int hold = nums[0];
        int len = nums.length;
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {

            index = (index + k) % len;
            if (visited[index]) {
                index = (index + 1) % len;
                hold = nums[index];
                i--;
            } else {
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }
}
