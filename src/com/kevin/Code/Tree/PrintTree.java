package com.kevin.Code.Tree;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname PrintTree
 * @Description 剑指offer32-1 广度优先搜索 从左到右 中等难度 层序遍历
 * @Date 2021/8/1 14:49
 * @Version 1.0
 */
public class PrintTree {
    public static void main(String[] args) {


    }

    /**
     *
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[]{};
        }

        //队列
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
//        TreeNode node = root;

        //首先把头结点增加进队列
        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            list.add(node.val);

            if (node.left != null) {
                deque.addLast(node.left);

            }

            if (node.right != null) {
                deque.addLast(node.right);

            }


        }

        //将ArrayList转换为数组
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }


}
