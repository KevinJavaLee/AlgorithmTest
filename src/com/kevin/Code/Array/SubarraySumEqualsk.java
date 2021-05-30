package com.kevin.Code.Array;

import java.util.HashMap;

/**
 * @Project LeetCode
 * @ClassName SubarraySumEqualsk
 * @Description Leetcode560 和为k的子数组 中等难度 没思路 思路不对
 * @Author Vinlee Xiao
 * @Date 2021/05/28/20:20
 * @Version 1.0
 */
public class SubarraySumEqualsk {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int i = subarraySum1(nums, 2);
        System.out.println(i);
    }


    /**
     * 想法：暴力破解 yyds 先暴力再优化 超出内存限制 需要优化
     *  输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        //用于存储和的个数

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j >=0; j--) {
                sum = sum + nums[j];
                if (sum == k) {
                    cnt++;
                }
            }

        }

        return cnt;
    }

    /**
     * 前缀和 + 哈希表优化 官方题解
     * 优化暴力算法
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {

        int len = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        //用于记录前缀和
        int pre = 0;
        //用于记录和为k的子数组
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (hashMap.containsKey(pre - k)) {
                cnt = cnt + hashMap.get(pre - k);
            }
            hashMap.put(pre, hashMap.getOrDefault(pre, 0)+1);

        }
        return cnt;
    }
}
