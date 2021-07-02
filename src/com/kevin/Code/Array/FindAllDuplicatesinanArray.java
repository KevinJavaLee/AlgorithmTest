package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName FindAllDuplicatesinanArray
 * @Description Leetcode 442数组中重复的数据 数组 中等难度 技巧性题目 类似Leetcode 287
 * @Author Vinlee Xiao
 * @Date 2021/05/30/10:42
 * @Version 1.0
 */
public class FindAllDuplicatesinanArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(nums);
        for (Integer duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }

    /**
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗
     * 思路：O(N)哈希表 但是 空间O(n)
     * 排序+查找
     * 此解非常巧妙，对于数值小于数组个数求重复数的题型,如果有重复的下标，
     * 那么通过下标对应的值作为下标，在数组中会被再次访问到
     * 重复数会形成圆环
     * @param nums
     * @return
     */
    public  static List<Integer> findDuplicates(int[] nums) {


        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 1) {
            result.add(nums[0]);

        }

        for (int i = 0; i < len; i++) {
            int tmp = Math.abs(nums[i]);

            if (nums[tmp - 1] < 0) {
                result.add(tmp);
            }else {
                nums[tmp - 1] = -nums[tmp - 1];
            }
        }

        return result;
    }
}
