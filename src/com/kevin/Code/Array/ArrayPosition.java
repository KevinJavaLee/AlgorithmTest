package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname ArrayPosition
 * @Description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 简单题 自己有思路
 * @Date 2021/9/4 19:00
 * @Version 1.0
 */
public class ArrayPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 7};
        int[] arr = exchange(nums);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    /**
     * 双指针思路：
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return new int[]{};
        }
        int slow = 0;
        int fast = 0;

        while (fast < len && slow < len) {

            if (nums[slow] % 2 == 0) {

                if (slow > fast) {
                    fast = slow;
                }
//
                while (fast < len && nums[fast] % 2 == 0) {

                    fast++;
                }

                if (fast < len) {
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
//                    slow = fast;
                }

            }
            slow++;
        }

        return nums;
    }
}
