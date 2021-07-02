package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName SearchNumCount
 * @Description 剑指 Offer 53 - I. 在排序数组中查找数字 I 简单 题解有意思
 * @Author Vinlee Xiao
 * @Date 2021/05/09/11:54
 * @Version 1.0
 */
public class SearchNumCount {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int i = search1(nums,8);
        System.out.println(i);
    }

    /**
     * 题解1：
     * 思路：二分法 看起来简单 实际不简单
     * @param nums
     * @param target
     * @return
     */
    public  static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        //用于记录target出现的次数
        //求右边界
        int cnt = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int right = low;
        System.out.println(right);
        if (high >= 0 && nums[high] != target) {
            return 0;
        }
        low = 0;
        high = nums.length - 1;
        //求左边界
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int left = high;
        System.out.println(left);

        return right - left - 1;
    }

    /**
     * 改进思路为寻找target和target-1的位置
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        return binarySearch(nums,target)-binarySearch(nums,target-1);
    }

    public static int binarySearch(int[] nums,int target) {
        int low = 0, high = nums.length - 1;
        //用于记录target出现的次数
        //求右边界
        int cnt = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
