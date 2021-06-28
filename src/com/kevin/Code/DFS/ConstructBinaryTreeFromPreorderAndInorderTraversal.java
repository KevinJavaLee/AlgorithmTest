package com.kevin.Code.DFS;

import com.kevin.Code.Tree.TreeNode;

import java.util.HashMap;

/**
 * @Project LeetCode
 * @ClassName ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @Description Leetcode 105 从前序遍历与中序遍历序列构造二叉树 dfs 中等难度 中频 经典题目
 * @Author Vinlee Xiao
 * @Date 2021/06/28/20:44
 * @Version 1.0
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preorder, inorder);

        printTree(treeNode);
    }

    /**
     * 根据前序遍历贺中序遍历来构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //先序遍历的hash表 健用于存储值 值存储坐标
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        int len = inorder.length;
        //用hash表来存储中序遍历中根节点的位置
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode node = DFS(preorder, inorder, 0, len - 1, 0, len - 1, inorderMap);

        return node;
    }

    /**
     * 思路：先序遍历的第一个结点是根节点
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @param inorderMap
     * @return
     */
    public static TreeNode  DFS(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right,HashMap<Integer,Integer> inorderMap) {

        //终止递归的条件
        if (preorder_left > preorder_right) {
            return null;
        }

        //先序遍历的根节点等于先序遍历的左边界
        int preorder_root = preorder_left;

        //找出中序遍历根节点的坐标
        int inorder_root = inorderMap.get(preorder[preorder_root]);

        //得到根节点的左子树结点的个数
        int left_subtree = inorder_root - inorder_left;

        //建立根结点
        TreeNode treeNode = new TreeNode(inorder[inorder_root]);

        //连接左子树
        //先序遍历中左子树的结点和中序遍历的左子树数量相同  所以先序遍历的左子树开始坐标为preorder+1,
        treeNode.left = DFS(preorder, inorder, preorder_left + 1, preorder_left + left_subtree, inorder_left, inorder_root - 1, inorderMap);

        //连接右子树
        //
        treeNode.right = DFS(preorder, inorder, preorder_left + left_subtree + 1, preorder_right, inorder_root + 1, inorder_right, inorderMap);

        //最后返回最终的结果

        return treeNode;
    }


    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);

    }
}
