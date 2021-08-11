package com.kevin.Code.Tree;

/**
 * @author Vinlee Xiao
 * @Classname DiameterOfBinaryTree
 * @Description Leetcode 543 二叉树的直径 简单题  值得再做 没啥思路
 * @Date 2021/8/11 15:51
 * @Version 1.0
 */
public class DiameterOfBinaryTree {
    int res;
//    public static void main(String[] args) {
//
//    }


    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点。
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root);
        return res - 1;
    }

    /**
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(left + right + 1, res);
        return Math.max(left, right) + 1;

    }
}
