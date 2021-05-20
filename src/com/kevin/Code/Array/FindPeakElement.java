package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName FindPeakElement
 * @Description Leetcode 162 寻找峰值 中等难度 中频 有意思
 * @Author Vinlee Xiao
 * @Date 2021/05/20/21:10
 * @Version 1.0
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        int i = findPeakElement1(nums);
        System.out.println(i);
    }

    /**
     * 常规暴力法
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }


        int target = 0;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i + 1] < nums[i]) {
                target = i;
                break;
            }
        }
        //两种特殊情况
        //从小排到大 从大到小
        if (target == 0) {
            return nums[0] < nums[len - 1] ? len - 1 : 0;
        }
        return target;
    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public static int findPeakElement1(int[] nums) {

        int len = nums.length;
        int low = 0, high = len - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }else {
                low = mid + 1;
            }

        }

        return low;
    }


}
