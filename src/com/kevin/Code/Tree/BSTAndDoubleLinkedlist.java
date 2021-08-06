package com.kevin.Code.Tree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname BSTAndDoubleLinkedlist
 * @Description 剑指Offer36 二叉搜索树与双向链表 中等难度 值得一做
 * @Date 2021/8/6 15:27
 * @Version 1.0
 */
public class BSTAndDoubleLinkedlist {


    Node head,pre;
//    public static void main(String[] args) {
//
//        Node node = new Node(4);
//        Node node1 = new Node(2);
//        Node node2 = new Node(5);
//        Node node3 = new Node(1);
//        Node node4 = new Node(3);
//
//        node.left = node1;
//        node.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//
//        Node tree = treeToDoublyList1(node);
//
//    }


    /**
     * 思路:简单思路：用栈来实现：方法需要创建新的节点不符合题目要求
     * @param root
     * @return
     */
//    public static Node treeToDoublyList(Node root) {
//
//        if (root == null) {
//            return root;
//        }
//
//        Node head = new Node();
//        if (root.left == null && root.right == null) {
//            head = root;
//            root.left = root;
//            root.right = root;
//            return root;
//        }
//
//        Deque<Node> deque = new LinkedList<>();
//
//        inOrder(root, deque);
//        //得到出队列的第一个节点
//        Node preNode = deque.pollLast();
//        Node first = preNode;
//        //出栈
////        int dequeSize = deque.size();
//        while (!deque.isEmpty()) {
//
//            Node node = deque.pollFirst();
//            node.left = preNode;
//            preNode.right = node;
//            preNode = node;
//
//        }
//        preNode.right = first;
//        first.left = preNode;
//
//
//        return first;
//    }

    /**
     *
     * @param root
     * @param deque
     */
    public  void inOrder(Node root, Deque<Node> deque) {

        if (root == null) {
            return;
        }

        inOrder(root.left, deque);
        deque.addLast(root);
        inOrder(root.right, deque);
    }


    /**
     *
     * 中序遍历顺序
     * @param root
     * @return
     */
    public  Node treeToDoublyList1(Node root) {

        if (root == null) {
            return null;
        }
        Node head = null;
//        System.out.println(head==null);
        Node pre = null;
        dfs(root);
//        System.out.println(head);
//        System.out.println(pre);
        head.left = pre;
        pre.right = head;

        return head;
    }

    /**
     *
     * @param cur

     */
    public  void dfs(Node cur) {

        if (cur == null) {
            return;
        }
        dfs(cur.left);

        if (pre != null) {
//            System.out.println(pre);
            pre.right = cur;
        } else {
            head = cur;

        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);

    }
}
