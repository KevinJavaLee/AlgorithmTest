package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName NextPermutation
 * @Description Leetcode31 下一个排序 中等难度 高频 看题解才会
 * @Author Vinlee Xiao
 * @Date 2021/05/14/20:36
 * @Version 1.0
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    /**
     *下一个排列
     * @param nums
     */
    public static void nextPermutation(int[] nums) {

        int len = nums.length;

        //1.第1步：找出nums[i] < nums[i+1] 如果找不到 i < 0
        int i = len-2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //第2步：从(i+1,n)中找出a[j]>a[i]

        if (i >= 0) {
            int j = len - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }

            //交换两个数
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }



        //第3步：对（i+1,n)数据进行逆序 利用双指针法
        int left = i + 1, right = len - 1;
        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
