package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName FindFirstAndLastPositionofelementinsortedArray
 * @Description Leetcode34. 在排序数组中查找元素的第一个和最后一个位置 中等难度 中频 思路和剑指offer57类似
 * @Author Vinlee Xiao
 * @Date 2021/05/16/19:54
 * @Version 1.0
 */
public class FindFirstAndLastPositionofelementinsortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] targets = searchRange(nums, 8);
        for (int i : targets) {
            System.out.println(i);
        }
    }

    /**
     * 思路：和剑指offer53不同
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int low = 0, high = len - 1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        int right = low;

        //对low 和high重新进行赋值
        low = 0;
        high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        int left = high;

        if (left + 1 < len && nums[left + 1] == target) {
            left = left + 1;
        }else {
            left = -1;
        }

        if (right-1 >= 0 && nums[right - 1] == target) {
            right = right - 1;
        } else {
            right = -1;
        }

        return new int[]{left, right };
    }
}
