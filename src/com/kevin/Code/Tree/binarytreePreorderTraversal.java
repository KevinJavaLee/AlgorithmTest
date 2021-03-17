package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//import java.util.Stack;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-11-13-19:17
 */
public class binarytreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        node.val = 10;
        node1.val = 12;
        node2.val = 2;
        node3.val = 14;
        node4.val = 15;
        node5.val = 7;
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        List<Integer> list = binaryPreorderTraversal(node);
        for (Integer data : list) {
            System.out.print(data + "       ");
        }


    }
    public static List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        preorder(root,list);

        return list;
    }

    /**
     * 二叉树的前序遍历递归算法
     * @param root
     * @param list
     */
    public static void preorder(TreeNode root,ArrayList<Integer> list) {

        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    /**
     * 二叉树先序遍历的非递归算法
     * @param root
     * @return
     */
    public static List<Integer> binaryPreorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = root;

        Stack<TreeNode> treeStack = new Stack<TreeNode>();

        /**
         *栈为非空
         */
        while (node != null || !treeStack.isEmpty()) {

            while (node != null) {
                list.add(node.val);
                treeStack.push(node);
                node = node.left;
            }

            node = treeStack.pop();
            node = node.right;
        }


        return list;
    }
}
