package com.kevin.Code.DFS;


import com.kevin.Code.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Project LeetCode
 * @ClassName SymmetricTree
 * @Description Leetcode 101 对称二叉树 深度优先遍历 简单 思路不太好 高频题
 * @Author Vinlee Xiao
 * @Date 2021/06/03/21:29
 * @Version 1.0
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(2);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.left = treeNode5;
        treeNode4.left = treeNode6;


        System.out.println();
        boolean b = isSymmetric2(treeNode);
        System.out.println(b);
    }


    /**
     * 最初思路，
     * 左子树从左遍历，右子树从右遍历
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        dfs_left(root.left,left);
        dfs_right(root.right,right);

        for (Integer e : left) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (Integer e : right) {
            System.out.print(e + " ");
        }
        return left.equals(right);
    }

    /**
     * 深度优先遍历
     */
    public static void dfs_left(TreeNode root, ArrayList<Integer> left) {
        if (root == null) {
            left.add(-1);
            return;
        }

        if (root.left == null && root.right == null) {
            left.add(root.val);
            return;
        }
        //中序遍历
        left.add(root.val);
        dfs_left(root.left, left);

        dfs_left(root.right, left);



    }

    public static void dfs_right(TreeNode root, ArrayList<Integer> right) {
        if (root == null) {
            right.add(-1);
            return;
        }

        if (root.left == null && root.right == null) {
            right.add(root.val);
            return;
        }
        //中序遍历
        right.add(root.val);
        dfs_right(root.right, right);

        dfs_right(root.left, right);
    }

    /**
     * Leetcode官方题解
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        boolean check = check(root, root);
        return check;
    }

    /**
     * @return
     */
    public static boolean check(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && (check(p.left, q.right)) && (check(p.right, q.left));
    }

    /**
     *迭代广度优先遍历
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        boolean b = check1(root, root);
        return b;
    }

    /**
     * 广度优先遍历 一般使用对列
     * @param p
     * @param q
     * @return
     */
    public static boolean check1(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(p);
        deque.addLast(q);

        while (!deque.isEmpty()) {
            p = deque.pollFirst();
            q = deque.pollFirst();

            /**
             * 如果两个节点都为空,则访问下一个节点
             */
            if (p == null && q == null) {
                continue;
            }

            if (p == null || q == null || (p.val != q.val)) {
                return false;
            }

            deque.addLast(p.left);
            deque.addLast(q.right);

            deque.addLast(p.right);
            deque.addLast(q.left);

        }
        return true;
    }
}
