package com.kevin.Code.LinkNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第19题 删除链表的倒数第N个结点
 * @create 2021-04-10 11:39
 * @project LeetCode
 * @Version 1.0
 */
public class RemoveNthnodeFromendofList {
    public static void main(String[] args) {
        ListNode left1 = new ListNode(1);
//        ListNode left2 = new ListNode(2);
//        ListNode left3 = new ListNode(3);
//        ListNode left4 = new ListNode(4);
//        ListNode left5 = new ListNode(5);

//        left1.next = left2;
//        left2.next = left3;
//        left3.next = left4;
//        left4.next = left5;

        ListNode node = removeNthFromEnd(left1, 1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    /**
     *采用栈的思想
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1,head);
        ListNode move = dummy;
        Deque<ListNode> deque = new LinkedList<>();


        while (move != null) {
            deque.addLast(move);
            move = move.next;

        }

        for (int i = 0; i < n; i++) {
            deque.pollLast();
        }


            ListNode pre = deque.peekLast();
            pre.next = pre.next.next;




        ListNode ans  = dummy.next;

        return ans;
    }
}
