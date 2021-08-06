package com.kevin.Code.Tree;

/**
 * @author Vinlee Xiao
 * @Classname BinarySearchTreePostOrder
 * @Description 剑指 Offer 33. 二叉搜索树的后序遍历序列 没啥思路 对二叉搜索树概念不熟悉 递归
 * @Date 2021/8/1 17:21
 * @Version 1.0
 */
public class BinarySearchTreePostOrder {
    public static void main(String[] args) {

    }

    /**
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {

        if (postorder.length == 0) {
            return false;
        }

        boolean res = help(postorder, 0, postorder.length - 1);

        return res;
    }


    /**
     *
     * @param postorder 后续遍历
     * @param low
     * @param high
     * @return
     */
    public static boolean help(int[] postorder, int low, int high) {

        //退出递归的条件
        if (low >= high) {
            return true;
        }

        int move = low;

        while (postorder[move] < postorder[high]) {
            move++;
        }

        int mid = move;

        while (postorder[move] > postorder[high]) {
            move++;
        }

        return move == high && help(postorder, low, mid - 1) && help(postorder, mid, high - 1);
    }
}
