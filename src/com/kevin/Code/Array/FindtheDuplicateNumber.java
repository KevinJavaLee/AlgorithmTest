package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName FindtheDuplicateNumber
 * @Description Leetcode 287 寻找重复数 中等难度 双指针有思路 思路同Leetcode 142环形链表2 经典
 * @Author Vinlee Xiao
 * @Date 2021/05/28/15:12
 * @Version 1.0
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        int i = findDuplicate1(nums);
        System.out.println(i);
    }

    /**
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间
     *思路：双指针的思路 时间复杂度太高 没有通过
     * nums = [1,3,4,2,2]
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0;
        int right = 1;
        while (left < len) {

            if (right < len && nums[left] == nums[right]) {

                return nums[left];
            }
            if (right >= len) {
                left++;
                right = left;
            }
            right++;
        }
        return 0;
    }

    /**
     * 官方双指针太抽象，不容易理解
     * 双指针的思路：首先找到相遇点
     * 慢指针再从头开始移动到环形链表的入口处
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums){

        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
