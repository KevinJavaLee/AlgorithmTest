package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName JumpGame
 * @Description Leetcode55 跳跃游戏 中等难度  贪心算法 中频 没啥思路
 * @Author Vinlee Xiao
 * @Date 2021/05/20/21:50
 * @Version 1.0
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    /**
     * 题目意思没看懂
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 思路：贪心算法
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {

        int len = nums.length;
        //维护最远可以到达的位置
        int mostStep = 0;

        for (int i = 0; i < len; i++) {
            if (i <= mostStep) {
                mostStep = Math.max(mostStep, i + nums[i]);

                if (i + nums[i] > len - 1) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     *从后往前遍历
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {

        int len = nums.length;
        //用于记录最后一个可以到达的位置
        int lastIndex = len - 1;

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] + i >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0;
    }

}
