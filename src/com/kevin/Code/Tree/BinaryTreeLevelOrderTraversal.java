package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname BinaryTreeLevelOrderTraversal
 * @Description Leetcode 102二叉树的层序遍历 中等难度 同剑指Offer32
 * @Date 2021/8/10 21:25
 * @Version 1.0
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new LinkedList<>();

        bfs(root, list);


        return list;
    }

    /**
     * @param root
     * @param list
     */
    public static void bfs(TreeNode root, List<List<Integer>> list) {

        //1.定义一个队列用于储存结点
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> subList = new ArrayList<>();

        //2.先把root结点加入队列中
        deque.addLast(root);

        //3.

        while (!deque.isEmpty()) {

            //求出栈中目前所含元素大小
            int nodeSize = deque.size();

            for (int i = 0; i < nodeSize; i++) {
                TreeNode node = deque.pollFirst();
                subList.add(node.val);

                if (node.left != null) {
                    deque.addLast(node.left);

                }

                if (node.right != null) {
                    deque.addLast(node.right);

                }
            }

            list.add(subList);
            subList = new ArrayList<>();
        }

    }
}
