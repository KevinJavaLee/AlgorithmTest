package com.kevin.Code.Tree;

import java.util.*;

/**
 * @author Vinlee Xiao
 * @Classname PrintTreeiii
 * @Description 剑指 Offer 32 - III. 从上到下打印二叉树 III 中等难度有思路
 * @Date 2021/8/1 16:08
 * @Version 1.0
 */
public class PrintTreeiii {
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
        List<List<Integer>> lists = levelOrder(node);

        for (List<Integer> list : lists) {
            for (Integer e : list) {
                System.out.print(e+" ");
            }
            System.out.println();
        }

    }


    /**
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }

        //队列
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
//        TreeNode node = root;

        //首先把头结点增加进队列
        deque.addLast(root);

        int cnt = 1;
        while (!deque.isEmpty()) {

            ArrayList<Integer> tmp = new ArrayList<>();
            //用来记录打印的顺序

            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();
                tmp.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);

                }

                if (node.right != null) {
                    deque.addLast(node.right);

                }

            }

            if (cnt % 2 == 0) {
                Collections.reverse(tmp);
            }

            cnt += 1;


            list.add(tmp);
        }

        return list;
    }
}
