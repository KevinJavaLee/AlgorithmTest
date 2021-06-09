package com.kevin.Code.Tree;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-23-21:18
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;

    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
