package com.kevin.Code.Tree;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname SumRoottoLeafNumbers
 * @Description Leetcode 129 求根节点到叶子节点数字之和 中等难度有思路
 * @Date 2021/9/17 21:49
 * @Version 1.0
 */
public class SumRoottoLeafNumbers {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(0);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(1);

        node.right = node1;
//        node.right = node2;
//        node1.left = node3;
//        node1.right = node4;

        int i = sumNumbers(node);
        System.out.println(i);
    }

    /**
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {
        int result = 0;
        List<Integer> combiner = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        dfs(root, combiner, res);

        for (Integer re : res) {
            result += re;
        }

        return result;
    }

    /**
     * @param root
     * @param combiner
     * @param res
     */
    public static void dfs(TreeNode root, List<Integer> combiner, List<Integer> res) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {

            combiner.add(root.val);
            int sum = 0;
            for (Integer e : combiner) {
                sum = sum * 10 + e;
            }

            res.add(sum);
//            System.out.println(res.get(res.size() - 1));
            return;
        }

        combiner.add(root.val);

        if (root.left != null) {
            dfs(root.left, combiner, res);
            combiner.remove(combiner.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, combiner, res);
            combiner.remove(combiner.size() - 1);
        }

        //将最后一个元素删除

    }

    public static int sumNumbers1(TreeNode root) {
        int res = helper(root, 0);
        return res;
    }

    /**
     * @param root
     * @param preSum
     * @return
     */
    public static int helper(TreeNode root, int preSum) {

        if (root == null) {
            return 0;
        }

        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }


}
