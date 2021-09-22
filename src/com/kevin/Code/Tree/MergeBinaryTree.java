package com.kevin.Code.Tree;

/**
 * @author Vinlee Xiao
 * @Classname MergeBinaryTree
 * @Description Leetcode 617. 合并二叉树 简单题
 * @Date 2021/9/21 20:45
 * @Version 1.0
 */
public class MergeBinaryTree {
    public static void main(String[] args) {

    }


    /**
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode node = dfs(root1, root2);

        return node;
    }


    /**
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode dfs(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode node = null;
        TreeNode nodeLeft1 = null;
        TreeNode nodeLeft2 = null;
        TreeNode nodeRight1 = null;
        TreeNode nodeRight2 = null;


        int nodeValue1 = 0;
        int nodeValue2 = 0;
        if (root1 != null) {
            nodeValue1 = root1.val;
            nodeLeft1 = root1.left;
            nodeRight1 = root1.right;
        }

        if (root2 != null) {
            nodeValue2 = root2.val;
            nodeLeft2 = root2.left;
            nodeRight2 = root2.right;
        }

        node = new TreeNode(nodeValue1 + nodeValue2);

        node.left = dfs(nodeLeft1, nodeLeft2);
        node.right = dfs(nodeRight1, nodeRight2);

        return node;
    }


    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }


        TreeNode node = null;

        node = new TreeNode(root1.val + root2.val);

        node.left = mergeTrees1(root1.left, root2.left);
        node.right = mergeTrees1(root1.right, root2.right);

        return node;
    }
}
