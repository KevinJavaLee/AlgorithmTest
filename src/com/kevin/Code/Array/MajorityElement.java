package com.kevin.Code.Array;

import java.util.HashMap;

/**
 * @Project LeetCode
 * @ClassName MajorityElement
 * @Description Leetcode 169 多数元素 简单 高频 有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/15/11:39
 * @Version 1.0
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    /**
     * 思路1：堆排序+
     * 思路2：hash算法 时间复杂度n,空间复杂度n
     * 思路3：随机操作
     * @param nums
     * @return
     */
    public  static int majorityElement(int[] nums) {

        int len = nums.length;
        int cnt = len / 2;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int count = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], count + 1);
            if (count + 1 > cnt) {

                return nums[i];
            }
        }

        return 0;
    }

    /**
     * 根据数据的特点进行处理
     * 时间复杂度O(N)
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        return 0;
    }


    /**
     * 根据快速分区的思想进行处理：
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {

        return 0;
    }
}
