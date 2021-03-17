package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-11-13-22:14
 */
public class binaryTreePostorderTraversal {

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
        List<Integer> list = binaryPostOrder(node);
        for (Integer data : list) {
            System.out.print(data + " ");
        }
    }


    /**
     * 二叉树后续遍历的递归算法
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    /**
     *
     * @param root
     * @param list
     */
    public static void postOrder(TreeNode root, ArrayList<Integer> list) {


        TreeNode node = root;
        if (node == null) {
            return;
        }
        list.add(node.val);
        postOrder(node.left, list);
        postOrder(node.right,list);
    }

    public static List<Integer> binaryPostOrder(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = root;
        TreeNode preNode = null;
        Stack<TreeNode> treeStack = new Stack<>();

        //当节点不为空,以及栈不为空时
        while (node != null || !treeStack.isEmpty()) {

            while (node != null) {

                treeStack.push(node);
                node = node.left;

            }
            node = treeStack.pop();

            //防止回溯时重新访问
            //使用preNode的目的是为了不重复访问最右子节点的父节点
            if (node.right == null || node.right == preNode) {
                list.add(node.val);
                preNode = node;
                node = null;
            } else {
                treeStack.push(node);
                node = node.right;
            }
        }
        return list;
    }


}
