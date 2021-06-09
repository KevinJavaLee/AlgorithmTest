package com.kevin.Code;

/**
 * @Project LeetCode
 * @ClassName TreeNode
 * @Description 1
 * @Author Vinlee Xiao
 * @Date 2021/06/09/14:58
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
