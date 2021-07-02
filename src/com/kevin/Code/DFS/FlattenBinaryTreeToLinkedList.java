package com.kevin.Code.DFS;

import com.kevin.Code.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName FlattenBinaryTreeToLinkedList
 * @Description Leetcode 114 二叉树展开为链表 中等难度 中频 优化思路不好
 *
 * @Author Vinlee Xiao
 * @Date 2021/06/20/13:51
 * @Version 1.0
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;
        flatten(treeNode);

        printNode(treeNode);
    }

    /**
     * 思路：先用先序遍历,o(N)空间
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        List<TreeNode> order = new ArrayList<>();
        dfs(root,order);
        TreeNode move = root;
        for (TreeNode node : order) {
            move.left = null;
            move.right = node;
            move = node;
        }

    }

    /**
     *
     * @param root
     * @param order
     */
    public static void dfs(TreeNode root, List<TreeNode> order) {
        if (root == null ) {

            return;
        }
        order.add(root);
        dfs(root.left, order);
        dfs(root.right, order);

    }

    public static void printNode(TreeNode root) {
        if (root == null) {
            System.out.println("---");
            return;
        }
        System.out.println(root.val);
        printNode(root.left);
        printNode(root.right);

    }


    /**
     * 思路相同：当前结点的左子树的最右结点连接到当前结点的右结点
     * 使用O(1)课外空间
     * @param root
     */
    public static void helper(TreeNode root) {


        while (root != null) {
            //如果当前结点的左子树为空
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;

                //找到当前结点的左子树的右结点
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }


    public static void help(TreeNode root) {
        if (root == null) {
            return;
        }

        help(root.left);
        help(root.right);

        if (root.left != null) {

            TreeNode pre = root.left;

            //找到左子树的最右结点
            while (pre.right != null) {
                pre = pre.right;
            }

            //左子树的最右结点连接到当前结点的右子结点
            pre.right = root.right;

            //当前结点的右子节点置为当前结点的左子结点
            root.right = root.left;

            root.left = null;

        }
        root = root.right;
    }
}
