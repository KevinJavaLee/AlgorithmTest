package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname LowestCommonAncestorBinaryTreeI
 * @Description Leetcode 235 二叉搜索树的最近公共祖先 同剑指Offer68-I. 二叉搜索树的最近公共祖先 简单题型
 * @Date 2021/8/6 19:16
 * @Version 1.0
 */
public class LowestCommonAncestorBinaryTreeI {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        TreeNode node9 = lowestCommonAncestor(node, node1, node4);
        System.out.println(node9.val);

    }

    /**
     * 思路：
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> pList = new LinkedList<>();
        Deque<TreeNode> qList = new LinkedList<>();

        if (root == null) {
            return null;
        }

        dfs(root, p, pList);
        dfs(root, q, qList);

        int size = pList.size() > qList.size() ? qList.size() : pList.size();
//        System.out.println(size);
        TreeNode qnode = null;
        TreeNode pnode = null;
        while (size > 0) {


            if (pList.peekFirst() != qList.peekFirst()) {

                break;
            }

            pnode = pList.pollFirst();
            qnode = qList.pollFirst();
            size--;

        }

        return pnode;
    }

    /**
     * 利用二叉搜索树的特点来进行解题
     *
     * @param root
     * @param p
     * @param nodeArrayList
     */
    public static void dfs(TreeNode root, TreeNode p, Deque<TreeNode> nodeArrayList) {

        while (root.val != p.val) {
            nodeArrayList.addLast(root);

            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        nodeArrayList.addLast(p);


    }

}
