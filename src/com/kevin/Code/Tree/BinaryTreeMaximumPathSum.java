package com.kevin.Code.Tree;

import com.sun.xml.internal.ws.encoding.MtomCodec;

/**
 * @author Vinlee Xiao
 * @Classname BinaryTreeMaximumPathSum
 * @Description Leetcode 124. 二叉树中的最大路径和 二叉树  困难 值得再做
 * @Date 2021/9/15 17:24
 * @Version 1.0
 */
public class BinaryTreeMaximumPathSum {

    int maxPath = Integer.MIN_VALUE;


    /**
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val;
        }
        dfs(root);
        return maxPath;
    }


    /**
     * @return
     */
    private int dfs(TreeNode root) {

        //递归中止条件
        if (root == null) {
            return 0;
        }

        //树的后序遍历
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);


        int total = Math.max(root.val, Math.max(leftPath, rightPath) + root.val);

        int sum = Math.max(total, root.val + leftPath + rightPath);

        maxPath = Math.max(maxPath, sum);
        System.out.println(maxPath);

        return total;
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum pathSum = new BinaryTreeMaximumPathSum();

        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        node.left = node1;
        node1.left = node2;

        int i = pathSum.maxPathSum(node);
        System.out.println(i);


    }
}
