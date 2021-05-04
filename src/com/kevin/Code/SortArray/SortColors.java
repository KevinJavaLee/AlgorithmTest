package com.kevin.Code.SortArray;

/**
 * @Project LeetCode
 * @ClassName SortColors
 * @Description Leetcode 75. 颜色分类 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/05/04/17:03
 * @Version 1.0
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 题目要求：
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * 思路：将0都移到第一部分 1移动到第二部分
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int len = nums.length;

        //用于记录第一部分0最后的位置
        int index = 0;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[index];
                nums[index] = 0;
                index++;
            }
        }

        //第二次循环用于将1插入到0之后
        for (int j = index; j < len; j++) {
            if (nums[j] == 1) {
                nums[j] = nums[index];
                nums[index] = 1;
                index++;
            }
        }
    }
}
