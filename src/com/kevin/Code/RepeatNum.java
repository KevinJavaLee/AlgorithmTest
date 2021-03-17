package com.kevin.Code;

import java.util.HashMap;

/**
 * @author Vinlee xiao
 * @Description: 剑指OFFER03题
 * @create 2021-03-17 19:58
 * @project LeetCode
 * @Version 1.0
 */
public class RepeatNum {
    public static void main(String[] args) {
        int []arr = new int[]{2, 3, 1, 0, 2, 5, 3};

        int repeatNumber = findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }

    /**
     * 用hash表解决问题
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int flag = -1;
        for (int i = 0; i < nums.length; i++) {



            //1.如果存在于hash表中，则返回该数
            if (!hashMap.isEmpty() && hashMap.containsKey(nums[i])) {
                flag = nums[i];
                return flag;
            }else {
                hashMap.put(nums[i],1);
            }


        }

        return flag;
    }


    /**
     * Leetcode 题解原地置换法
     *
     */
}
