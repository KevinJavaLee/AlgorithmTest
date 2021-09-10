package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname ArrayTwoSum
 * @Description 剑指 Offer 57 和为s的两个数 简单题 再做
 * @Date 2021/9/10 19:14
 * @Version 1.0
 */
public class ArrayTwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
//        int i = binarySearch(nums, 76, 0, nums.length - 1);
//        System.out.println(i);
        int[] sum = twoSum(nums, 9);
        for (int i : sum) {
            System.out.println(i);
        }

    }

    public static int binarySearch(int[] nums, int target, int low, int high) {
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        }

        return high == 0 ? high : high + 1;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        if (len == 1) {
            return new int[]{};
        }

        int index = binarySearch(nums, target, 0, nums.length - 1);
//        System.out.println("index:" +index);
        int slow = 0;
        int fast = index - 1;
        //双指针解决问题：
        while (slow < index) {

            if (nums[slow] + nums[fast] == target) {
                return new int[]{nums[slow], nums[fast]};
            } else if (slow >= fast || nums[slow] + nums[fast] < target) {

                slow++;
                fast = index;
            }
            fast--;
        }

        return new int[]{};
    }
}
