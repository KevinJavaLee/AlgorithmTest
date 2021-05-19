package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName CombinationSum  很经典经典的回溯题
 * @Description Leetcode 39 组合总和 中等难度 中频  看题解才有思路 回溯算法 重要
 * @Author Vinlee Xiao
 * @Date 2021/05/19/19:30
 * @Version 1.0
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,6,3,7};
        List<List<Integer>> lists = combinationSum(nums, 7);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }

    /**
     * candidates = [2,6,3,7], target = 7
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //求长度
        int len = candidates.length;
        //1.首先对数据进行排序
        Arrays.sort(candidates);
        List<List<Integer>> totalSum = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();

        //start为开始坐标
//        dfs(candidates, target, totalSum, combine, 0);
        helper(candidates,target,totalSum,combine,0);
        return totalSum;
    }

    /**
     * 回溯算法 + 剪枝
     */
    public static void dfs(int[] candidates, int target, List<List<Integer>> totalSum, List<Integer> combine, int start) {

        //终止条件
        if (start == candidates.length) {
            return;
        }

        //目标函数为0
        if (target == 0) {
            totalSum.add(new ArrayList<Integer>(combine));
            return;
        }

        //
        dfs(candidates, target, totalSum, combine, start + 1);

        //继续向下回溯
        if (target - candidates[start] >= 0) {
            combine.add(candidates[start]);
            dfs(candidates,target - candidates[start],totalSum,combine,start);
            combine.remove(combine.size() - 1);
        }
    }

    /**
     * 回溯剪枝
     * @param candidates
     * @param target
     * @param totalSum
     * @param combine
     * @param start
     */
    public static void helper(int[] candidates, int target, List<List<Integer>> totalSum, List<Integer> combine, int start){
        //终止条件
        if (start == candidates.length) {
            return;
        }

        //目标函数为0
        if (target == 0) {
            totalSum.add(new ArrayList<Integer>(combine));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (target - candidates[i] < 0) {
                break;
            }

            combine.add(candidates[i]);
            helper(candidates, target - candidates[i], totalSum, combine, i);
            combine.remove(combine.size() - 1);
        }
    }


}
