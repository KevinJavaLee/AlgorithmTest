package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: 剑指 Offer 24. 反转链表
 * @create 2021-03-26 20:11
 * @project LeetCode
 * @Version 1.0
 */
public class ReverseList {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode head1 = new ListNode(2);
//        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(4);
//        ListNode head4 = new ListNode(5);
//        head.next = head1;
//        head1.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//
//        ListNode kthFromEnd = reverseList(head);
//
//        while (kthFromEnd != null) {
//            System.out.println(kthFromEnd.val);
//            kthFromEnd = kthFromEnd.next;
//        }

        ListNode head = null;
        ListNode node = reverseList(head);
        System.out.println(node);
    }


    /**
     * 头插法思想
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode nextData =head;

        if (head== null || head.next==null) {
            return head;
        }
        ListNode move=head.next;
        head.next = null;
        while (move != null) {

            nextData = move.next;
            move.next=head;
            head = move;
            move = nextData;

        }

        return head;
    }
}
