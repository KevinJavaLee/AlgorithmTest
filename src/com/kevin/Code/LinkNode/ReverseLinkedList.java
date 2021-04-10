package com.kevin.Code.LinkNode;

import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第92题反转链表
 * @create 2021-04-10 9:42
 * @project LeetCode
 * @Version 1.0
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode left1 = new ListNode(5);
//        ListNode left2 = new ListNode(2);
//        ListNode left3 = new ListNode(3);
//        ListNode left4 = new ListNode(4);
//        ListNode left5 = new ListNode(5);

//        left1.next = left2;
//        left2.next = left3;
//        left3.next = left4;
//        left4.next = left5;

        ListNode node = reverseBetween(left1, 1, 1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    /**
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        /**
         * 如果反转的两点位置相同，则直接返回节点
         */
        if (left == right) {
            return head;
        }

        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode move = head;

        //栈用于存储数据
        Stack<Integer> stack = new Stack<Integer>();

        //用于标记结点数
        int cnt = 0;
        while (move != null) {

            cnt++;
            if (left != 1 && cnt + 1 == left) {
                preNode = move;
            }
            if (cnt >= left && cnt <= right) {
                stack.push(move.val);
            }

            if (cnt == right && move.next != null) {
                nextNode = move.next;
                break;
            }
            move = move.next;
        }


//        ListNode move1 = null;
        if (preNode == null) {
            head.val = stack.pop();
            head.next = null;
            preNode = head;

        }


        //将链表反转
        while (!stack.isEmpty()) {
            int num = stack.pop();
            ListNode node = new ListNode(num);
            preNode.next = node;
            preNode = preNode.next;

        }

        //判断nextnode是否为空
        if (nextNode == null) {
            return head;
        }

        preNode.next = nextNode;
        preNode = preNode.next;



        return head;
    }
}
