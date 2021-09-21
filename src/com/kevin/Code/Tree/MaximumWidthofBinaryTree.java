package com.kevin.Code.Tree;

import java.util.HashMap;

/**
 * @author Vinlee Xiao
 * @Classname MaximumWidthofBinaryTree
 * @Description Leetcode 662. 二叉树最大宽度 中等难度 深度优先遍历 广度优先遍历
 * @Date 2021/9/21 18:30
 * @Version 1.0
 */
public class MaximumWidthofBinaryTree {

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    //记录最大的宽度数
    int maxWidth = 0;

    /**
     * 结合二叉树的序号好深度特点
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {

        dfs(root, 1, 1);

        return maxWidth;
    }


    /**
     * @param root
     * @return
     */
    public void dfs(TreeNode root, int depth, int position) {

        if (root == null) {
            return;
        }

        //如果不存在当前深度所对应的位置，则将当前depth放入HashMap中，
        hashMap.computeIfAbsent(depth, k -> position);


        dfs(root.left, depth + 1, position * 2);
        dfs(root.right, depth + 1, position * 2 + 1);
        maxWidth = Math.max(maxWidth, position - hashMap.get(depth) + 1);
    }

    public static void main(String[] args) {
        MaximumWidthofBinaryTree m = new MaximumWidthofBinaryTree();
    }
}
