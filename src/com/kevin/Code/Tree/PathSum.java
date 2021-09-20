package com.kevin.Code.Tree;

/**
 * @author Vinlee Xiao
 * @Classname PathSum
 * @Description Leetcode 112 路径总和  简单
 * @Date 2021/9/20 20:15
 * @Version 1.0
 */
public class PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        boolean b = dfs(root, targetSum, 0);
        return b;
    }


    /**
     * @param root
     * @param targetSum
     * @param preNum
     * @return
     */
    public boolean dfs(TreeNode root, int targetSum, int preNum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {

            if (targetSum == preNum + root.val) {
                return true;
            }

            return false;

        }

        preNum = preNum + root.val;


        return dfs(root.left, targetSum, preNum) || dfs(root.right, targetSum, preNum);
    }

}
