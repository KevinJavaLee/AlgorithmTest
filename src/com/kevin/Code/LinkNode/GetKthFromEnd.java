package com.kevin.Code.LinkNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点 使用双指针
 * @create 2021-03-26 18:54
 * @project LeetCode
 * @Version 1.0
 */
public class GetKthFromEnd {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode kthFromEnd = getKthFromEnd(head, 2);

        while (kthFromEnd != null) {
            System.out.println(kthFromEnd.val);
            kthFromEnd = kthFromEnd.next;
        }
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode former = head,lattern = head;

        for (int i = 0; i < k; i++) {

            if (former == null) {
                return null;
            }
            former = former.next;
        }

        while (former != null) {
            former = former.next;
            lattern = lattern.next;
        }

        return lattern;
    }
}
