package com.kevin.Code.Tree;

import java.util.HashMap;

/**
 * @author Vinlee Xiao
 * @Classname ConstructBinaryTree
 * @Description 剑指offer 07   同Leetcode 105 从前序遍历与中序遍历序列构造二叉树  中等难度 二叉树 没思路
 * @Date 2021/7/27 20:16
 * @Version 1.0
 */
public class ConstructBinaryTree {
    public static void main(String[] args) {

    }


    /**
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //hashmap用于存储
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }


        TreeNode node = help(preorder,inorder,0,preorder.length-1,0,inorder.length-1,hashMap);

        return node;
    }

    /**
     *
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @param hashMap
     * @return
     */
    public static TreeNode help(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right,HashMap<Integer,Integer> hashMap) {

        //递归中止条件
        if (preorder_right < preorder_left) {
            return null;
        }


        int preorder_root = preorder_left;

        //中序遍历的根节点
        int inorder_root = hashMap.get(preorder[preorder_root]);
        //建立根结点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //左结点
        int subtreeSize = inorder_root - inorder_left;

        root.left = help(preorder, inorder, preorder_left+1, preorder_left+subtreeSize, inorder_left, inorder_root - 1, hashMap);
        root.right = help(preorder, inorder, preorder_left + subtreeSize + 1, preorder_right, inorder_root + 1, inorder_right, hashMap);

        return root;
    }
}
