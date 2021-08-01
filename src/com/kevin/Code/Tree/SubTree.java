package com.kevin.Code.Tree;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author Vinlee Xiao
 * @Classname SubTree
 * @Description 剑指Offer 树的子结构 中等难度
 * @Date 2021/7/28 9:58
 * @Version 1.0
 */
public class SubTree {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(-4);
        TreeNode node4 = new TreeNode(3);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;


        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(-4);
        node7.left = node8;

//        TreeNode node9 = new TreeNode(1);
//        boolean b = isSubStructure(node, node7);
//        System.out.println(b);
        boolean b = dfs(node, node7);
        System.out.println(b);
    }

    /**
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {

//        //约定空树不是任何一棵树的子树
//        if (B == null) {
//            return false;
//        }
//
//
//        //1.查找B树中根节点在A树中的位置
//        TreeNode root = new TreeNode(B.val);
//        if (A != null && B != null) {
//
//            return false;
//        }

//        boolean res = false;
//        if (A.val == B.val) {
////            System.out.println(res);
//            res =  dfs(A, B);
//            System.out.println("res:" + res);
//        }


        return (A != null && B != null) && (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    /**
     *
     * @param node
     * @param subNode
     * @return
     */
    public static boolean dfs(TreeNode node,TreeNode subNode) {

        if (subNode == null) {
            return true;
        }

        if (node == null || node.val != subNode.val) {
            return false;
        }



        return dfs(node.left, subNode.left) && dfs(node.right, subNode.right);
    }

}
