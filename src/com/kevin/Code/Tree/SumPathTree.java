package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName SumPathTree
 * @Description 剑指 Offer 34 二叉树中和为某一值的路径 中等难度 类似 Leetcode 113路径总和 中等难度 有思路
 * @Author Vinlee Xiao
 * @Date 2021/06/02/21:43
 * @Version 1.0
 */
public class SumPathTree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(-2);
        TreeNode node1 = new TreeNode(-3);
//        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(11);
//        TreeNode node4 = new TreeNode(13);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(5);
//        TreeNode node9 = new TreeNode(1);
//        node.left = node1;
//        node.right = node2;
//        node1.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.left = node8;
//        node5.right = node9;
        node.right = node1;

        List<List<Integer>> lists = pathSum(node, -5);
        System.out.println(lists.size());

        for (List<Integer> list : lists) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param root
     * @param target
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int target) {

        List<Integer> combine = new ArrayList<>();
        List<List<Integer>> totalSum = new ArrayList<>();
        dfs(root, target,combine,totalSum);
        return totalSum;
    }


    /**
     * 深度优先遍历
     * @param root
     * @param target
     */
    public static void dfs(TreeNode root, int target,List<Integer> combine,List<List<Integer>> totalSum) {


        //递归结束条件
        if (root == null) {
            return;
        }
        int value = root.val;
        int sum = target - value;

        combine.add(value);
        if (sum == 0 && root.left == null && root.right == null) {
            totalSum.add(new ArrayList<>(combine));

        }

        dfs(root.left, sum,combine,totalSum);
        dfs(root.right, sum,combine,totalSum);
        combine.remove(combine.size() - 1);

    }


    }

