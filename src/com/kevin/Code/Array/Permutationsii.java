package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName Permutationsii
 * @Description Leetcode 47 全排列2 中等难度 回溯算法
 * @Author Vinlee Xiao
 * @Date 2021/05/19/21:50
 * @Version 1.0
 */
public class Permutationsii {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);

        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();

        dfs(nums, list, combine, 0);

        return list;

    }


    /**
     *
     */
    public static void dfs(int[] nums,List<List<Integer>> list,List<Integer> combine, int start) {

        if (nums.length == start) {
            list.add(new ArrayList<>(combine));
            return;
        }


        for (int i = start; i < nums.length; i++) {
            combine.add(nums[i]);
            dfs(nums,list,combine,i+1);
        }
    }
}
