package com.kevin.Code.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname BinaryTreeZigzagLevelOrderTraversal
 * @Description Leetcode103. 二叉树的锯齿形层序遍历 中等难度  同剑指Offer32
 * @Date 2021/8/11 14:25
 * @Version 1.0
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

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
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> subList = new LinkedList<>();
        boolean leftOrder = true;
        //2.先把root结点加入队列中
        queue.addLast(root);

        //3.
        while (!queue.isEmpty()) {

            //求出栈中目前所含元素大小
            int nodeSize = queue.size();

            for (int i = 0; i < nodeSize; i++) {
                TreeNode node = queue.pollFirst();

                if (leftOrder) {
                    subList.addLast(node.val);
                } else {
                    subList.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.addLast(node.left);

                }

                if (node.right != null) {
                    queue.addLast(node.right);

                }
            }
            leftOrder = !leftOrder;
            list.add(new ArrayList<>(subList));
            subList = new LinkedList<>();
        }

    }

}
