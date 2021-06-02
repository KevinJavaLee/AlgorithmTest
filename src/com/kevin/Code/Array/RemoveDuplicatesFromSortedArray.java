package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName RemoveDuplicatesFromSortedArray
 * @Description Leetcode 26 26. 删除有序数组中的重复项 简单 数组
 * @Author Vinlee Xiao
 * @Date 2021/06/02/19:42
 * @Version 1.0
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    /**
     * 思路
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0, right = 1;
        int index=0;
        if (len == 0) {
            return 0;
        }

        while (right < len) {

            while (nums[left] != nums[right]) {
                nums[index] = nums[left];
                index++;
                left = right;
            }
            right++;
        }
        nums[index] = nums[left];
        return index + 1;
    }
}
