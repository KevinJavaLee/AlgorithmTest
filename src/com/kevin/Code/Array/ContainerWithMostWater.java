package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName ContainerWithMostWater
 * @Description Leetcode 11 盛最多水的容器 中等难度 双指针 思路不好 经典的面试题
 * @Author Vinlee Xiao
 * @Date 2021/05/28/19:26
 * @Version 1.0
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] num = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(num);
        System.out.println(i);

    }

    /**
     * 思路1：双指针暴力法
     * 思路分析：当左边的数高度小于等于最右边的数高度时,移动左边的数找到比左边的数更大的数，才有可能取到更大的值
     * 而当右边的数更小时，移动右边的数找到比左边的数更大的数时，才会得到更大的取值
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        //数组的长度
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int ans = 0;
        int area = 0;
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans,area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
