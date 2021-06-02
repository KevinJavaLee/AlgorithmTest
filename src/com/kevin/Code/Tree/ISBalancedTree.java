package com.kevin.Code.Tree;

/**
 * @Project LeetCode
 * @ClassName ISBalancedTree
 * @Description 剑指offer 55 平衡二叉树深度
 * @Author Vinlee Xiao
 * @Date 2021/06/02/20:09
 * @Version 1.0
 */
public class ISBalancedTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;

//        int i = dfs(node);
//        System.out.println(i);
        boolean b = isBalanced(node);
        System.out.println();

    }

    /**
     * 思路:深度优先遍历
     * 判断是否食平衡二叉树
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {

        //停止迭代的条件
        if (root == null) {
            return true;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        //高度差大于1时
        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 求出二叉树的深度
     * @param root
     * @return
     */
    public static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }


        return Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }


    /**
     * 改进用法在遍历每个节点的时候，记录二叉树的高度
     * @param root
     * @return
     */
    public static boolean isBalanced1(TreeNode root) {
        return isBalanced1(root, 0);
    }

    public static boolean isBalanced1(TreeNode root,int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }

        //分布用于记录节点左右子树的高度
        int left = 0, right=0;
        if (isBalanced1(root.left, left) && isBalanced1(root.right, right)) {
            int diffrence = left - right;
            if (diffrence <= 1 && diffrence >= -1) {
                depth = Math.max(right + 1, left + 1);
                return true;
            }
        }
        return false;
    }
}
