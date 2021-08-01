package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname PrintTreeii
 * @Description 剑指 Offer 32 - II. 从上到下打印二叉树 II 同Leetcode102 简单题 没有思路
 * @Date 2021/8/1 15:28
 * @Version 1.0
 */
public class PrintTreeii {
    public static void main(String[] args) {

    }

    /**
     * 同一层的结点打印到一行 将同一层的结点全部添加进队列，将其子结点全部添加进栈
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            new ArrayList<Integer>(new ArrayList<Integer>());
        }

        //队列
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
//        TreeNode node = root;

        //首先把头结点增加进队列
        deque.addLast(root);

        while (!deque.isEmpty()) {

            ArrayList<Integer> tmp = new ArrayList<>();

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                //用于储存每一行的结点


                TreeNode node = deque.pollFirst();
                tmp.add(node.val);

                if (node.left != null) {
                    deque.addLast(node.left);

                }

                if (node.right != null) {
                    deque.addLast(node.right);

                }
            }

            list.add(tmp);


        }
        return list;
    }
}
