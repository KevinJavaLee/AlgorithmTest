package com.kevin.Code.Tree;

import java.util.HashMap;

/**
 * @author Vinlee Xiao
 * @Classname PathSumIII
 * @Description Leetcode 437 路径总和III 深度优先遍历 中等难度 没啥思路 前缀和思想
 * @Date 2021/9/21 20:34
 * @Version 1.0
 */
public class PathSumIII {
    //记录符合要求的数
//    int count = 0;
    public static void main(String[] args) {

    }

    /**
     * 前缀和的思想
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        //hashmap用于存储浅醉和
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int res = dfs(root, 0, hashMap, targetSum);

        return res;
    }


    /**
     * @param root
     * @param preSum
     * @param hashMap
     * @return
     */
    public int dfs(TreeNode root, int preSum, HashMap<Integer, Integer> hashMap, int targetSum) {


        //本层要做的事情
        int count = 0;
        if (root == null) {
            return 0;
        }

        preSum = preSum + root.val;

        count += hashMap.getOrDefault(preSum - targetSum, 0);
        //
        hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);

        count += dfs(root.left, preSum, hashMap, targetSum);

        count += dfs(root.right, preSum, hashMap, targetSum);


        hashMap.put(preSum, hashMap.get(preSum) - 1);


        return count;
    }
}
