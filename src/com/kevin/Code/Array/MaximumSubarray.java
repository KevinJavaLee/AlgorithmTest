package com.kevin.Code.Array;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Project LeetCode
 * @ClassName MaximumSubarray
 * @Description Leetcode 53. 最大子序和 高频
 * @Author Vinlee Xiao
 * @Date 2021/05/11/20:53
 * @Version 1.0
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray1(nums);
        System.out.println(i);
    }

    /**
     * 暴力法
     * nums = [-2,,-11,-3,4,2,1,-5,4]
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int sum = 0;
        int len = nums.length - 1;
        //对最大值进行初始化
        max = nums[0];
        for (int i = 0; i <= len ; i++) {
            sum = 0;
            for (int j = i; j <= len; j++) {
                sum = sum + nums[j];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    /**
     * nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 动态规划解决问题:若前一个元素大于0才加入元素
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums){
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length - 1;

        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        //求数组中最大的值
        int max = nums[0];
        for (int i = 0; i <= len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        
        
        return max;
    }


}
