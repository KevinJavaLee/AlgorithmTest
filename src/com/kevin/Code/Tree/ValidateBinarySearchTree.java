package com.kevin.Code.Tree;

/**
 * @author Vinlee Xiao
 * @Classname ValidateBinarySearchTree
 * @Description Leetcode 98 验证二叉搜索树 中等难度
 * @Date 2021/9/20 20:33
 * @Version 1.0
 */
public class ValidateBinarySearchTree {

    long lower = Long.MIN_VALUE;
    long upper = Long.MAX_VALUE;

//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(6);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(7);
//
//        node.left = node1;
//        node.right = node4;
//        node1.left = node2;
//        node1.right = node3;
//
//        boolean b = isValidBST(node);
//        System.out.println(b);
//    }

    /**
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        boolean b = dfs(root, lower, upper);

        return b;
    }


    /**
     * 对二叉树概念理解错误 参考题解
     *
     * @param root
     * @return
     */
    public boolean dfs(TreeNode root, long lower, long upper) {

        if (root == null) {
            return true;
        }

        if (root.val >= upper || root.val <= lower) {
            return false;
        }

        boolean left = dfs(root.left, lower, root.val);

        boolean right = dfs(root.right, root.val, upper);


        return left && right;

    }

    /**
     * 广度优先遍历 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        boolean b = dfs(root, lower, upper);

        return b;
    }

}
