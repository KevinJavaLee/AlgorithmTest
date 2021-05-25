package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName MinimumSizeSubarraySum
 * @Description Leetcode 209长度最小的子数组 中等难度 中频 有思路 滑动窗口
 * @Author Vinlee Xiao
 * @Date 2021/05/25/20:34
 * @Version 1.0
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int i = minSubArrayLen(11, nums);
        System.out.println(i);
    }

    /**
     * nums = [2,3,1,2,4,3]
     * 双指针法  子集思路
     * left 、right指针
     * 如果右指针和之前的数和小于target,右指针向前
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        while (left < len && right < len) {

//            if (nums[right] >= target) {
//                return 1;
//            }

            if (sum + nums[right] < target) {

                sum = sum + nums[right];
                right++;


            }else {
                minLength = Math.min(minLength, right - left + 1);
                left++;
                right = left;
                sum=0;
            }
        }

//        if (minLength == Integer.MAX_VALUE) {
//            return 0;
//        }

        return minLength==Integer.MAX_VALUE ? 0:minLength;
    }

    /**
     * 改进2:right不用重新置为0
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {

        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        while (right < len) {

//            if (nums[right] >= target) {
//                return 1;
//            }
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

//        if (minLength == Integer.MAX_VALUE) {
//            return 0;
//        }

        return minLength==Integer.MAX_VALUE ? 0:minLength;
    }

}
