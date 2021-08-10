package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname BinarySearchTreeOfKValue
 * @Description 剑指 Offer 54. 二叉搜索树的第k大节点 简单
 * @Date 2021/8/6 21:15
 * @Version 1.0
 */
public class BinarySearchTreeOfKValue {
    //分别为最终的结果
    int res, k;
//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(3);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(2);
////        TreeNode node = new TreeNode(3);
//
//        node.left = node1;
//        node.right = node2;
//        node1.right = node3;
//        int i = kthLargest(node, 1);
//        System.out.println(i);
//    }

    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return res;
    }

//    public static int kthLargest(TreeNode root, int k) {
//
//        List<Integer> list = new ArrayList<>();
//        dfs(root,list);
//        int size = list.size();
//        return list.get(size-k);
//    }

//    public static void dfs(TreeNode root,List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//
//        dfs(root.left, list);
//        list.add(root.val);
//        dfs(root.right,list);
//    }


    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        if (k == 0) {
            return;
        }
//        k--;
        if (--k == 0) {
            res = root.val;
        }
        helper(root.left);

    }
}
