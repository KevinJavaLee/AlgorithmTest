package com.kevin.Code.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname LowestCommonAncestorofBinaryTree
 * @Description Leetcode  236. 二叉树的最近公共祖先 同剑指 Offer 68 - II. 二叉树的最近公共祖先   中等难度 没啥思路
 * @Date 2021/8/1 17:15
 * @Version 1.0
 */
public class LowestCommonAncestorofBinaryTreeII {
    TreeNode res;
//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(3);
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(0);
//        TreeNode node6 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(4);
//
//        node.left = node1;
//        node.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        TreeNode node9 = lowestCommonAncestor(node, node1, node2);
//        System.out.println(node9.val);
//    }

    /**
     * 官方题解
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);

        return this.res;
    }

    /**
     * @param root
     * @param p
     * @param q
     */
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if ((left && right) || (root.val == p.val || root.val == q.val) && (left || right)) {
            res = root;
        }


        return left || right || (root.val == p.val) || (root.val == q.val);

    }
}
