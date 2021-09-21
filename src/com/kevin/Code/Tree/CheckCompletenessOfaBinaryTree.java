package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname CheckCompletenessOfaBinaryTree
 * @Description Leetcode 958. 二叉树的完全性检验 中等难度
 * @Date 2021/9/20 21:58
 * @Version 1.0
 */
public class CheckCompletenessOfaBinaryTree {
    int maxSize;
    int cnt;

    public static void main(String[] args) {

    }


    /**
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return true;
        }

        bfs(root, 1);
        System.out.println(maxSize);
        System.out.println(cnt);
        return maxSize == cnt;
    }

    /**
     * @param root
     * @param index
     */
    public void bfs(TreeNode root, int index) {

        if (root == null) {
            return;
        }

        cnt++;
        maxSize = Math.max(maxSize, index);


        bfs(root.left, 2 * index);

        bfs(root.right, index * 2 + 1);
    }


}
