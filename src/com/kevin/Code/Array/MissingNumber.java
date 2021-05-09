package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName MissingNumber
 * @Description 剑指 Offer 53 - II. 0～n-1中缺失的数字 简单
 * @Author Vinlee Xiao
 * @Date 2021/05/09/10:47
 * @Version 1.0
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3};
        int i = missingNumber(nums);
        System.out.println(i);
    }

    /**
     * 做法很巧妙
     * 排序数组中的搜索问题，首先想到的是二分法
     * 分成左右区间
     * 二分法查找
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }
}
