package com.kevin.Code.Tree;




import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-23-21:13
 */
public class binaryTtreeInorder {

    public static void main(String[] args) {

        /*1.中序遍历*/
        TreeNode treeNode = new TreeNode(12);
        TreeNode treeNode1 = new TreeNode(14);
        TreeNode treeNode2 = new TreeNode(44);
        TreeNode treeNode3 = new TreeNode(55);
        TreeNode treeNode4 = new TreeNode(77);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode3.right = treeNode4;

        List<Integer> list = inorderTraversal(treeNode);
        for (Integer integer : list) {
            System.out.println(integer);
        }


    }



//    public static List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//
//        inorder(root,list);
//
//
//        return list;
//    }
//
//    public static void inorder(TreeNode root, ArrayList<Integer> list) {
//
//        if (root == null) {
//            return;
//        }
//
//        inorder(root.left,list);
//
//        list.add(root.val);
//
//        inorder(root.right,list);
//    }

    /*非递归实现中序遍历*/

    public static List<Integer> inorderTraversal(TreeNode treeNode) {

        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> treeStack = new Stack<>();

        while (treeNode != null || !treeStack.isEmpty()) {

            while (treeNode != null ) {

                treeStack.push(treeNode);
                treeNode = treeNode.left;
            }

            treeNode = treeStack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;

        }

        return list;
    }




}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
