package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName SearchInRotatedSortedArray
 * @Description Leetcode 33. 搜索旋转排序数组 中等难度 高频
 * @Author Vinlee Xiao
 * @Date 2021/05/14/19:13
 * @Version 1.0
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int i = search(nums, 3);
        System.out.println(i);
    }


    /**
     * 有序的一般用二份查找 找到
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {

        int len = nums.length;
        if (len == 1 && nums[0] == target) {
            return 0;
        }

        //找到开始旋转的坐标
        int index = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == target) {
                return i-1;
            }

            if (nums[i] < nums[i - 1]) {
                index=i;
                break;
            }
        }

        System.out.println("index:" + index);
        //再使用二分查找
        int low = index;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }

        }


        return -1;
    }
}
