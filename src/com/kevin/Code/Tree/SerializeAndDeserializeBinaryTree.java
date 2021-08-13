package com.kevin.Code.Tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname SerializeAndDeserializeBinaryTree
 * @Description 297. 二叉树的序列化与反序列化 剑指Offer 37 困难 没啥思路
 * @Date 2021/8/13 15:13
 * @Version 1.0
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        String s = serialize(node);
        System.out.println(s);
        TreeNode treeNode = deserialize(s);
        PrintTree(treeNode);

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        return rSerialize(root, "");
    }

    /**
     * @param root 按照先序遍历将结点拼接成字符串
     * @return
     */
    public static String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "NONE,";
        } else {

            int val = root.val;
            str += val + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

//    public static void rSerizlize(String str){
//
//
//    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        //将字符串分割为字符数组
        String[] split = data.split(",");
        //将字符串数组转换为链表
        LinkedList<String> es = new LinkedList<String>(Arrays.asList(split));

        TreeNode node = rDeserialize(es);

        return node;
    }

    public static TreeNode rDeserialize(LinkedList<String> list) {

        //如果碰到NONE
        if (list.get(0).equals("NONE")) {
            list.remove(0);
            return null;
        }
        int i = Integer.parseInt(list.get(0));
        TreeNode node = new TreeNode(i);
        list.remove(0);
        node.left = rDeserialize(list);
        node.right = rDeserialize(list);

        return node;
    }

    public static void PrintTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        System.out.print(val + " ");
        PrintTree(root.left);
        PrintTree(root.right);
    }

}
