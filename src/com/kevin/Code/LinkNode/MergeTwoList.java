package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第21题合并有序链表
 * @create 2021-04-11 20:50
 * @project LeetCode
 * @Version 1.0
 */
public class MergeTwoList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
//        head2.next = head3;
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);

        head3.next = head4;
        head4.next = head5;

        ListNode node = mergeTwoLists(head, head3);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1,head2 = l2;


        ListNode dummy = new ListNode(-1,l1);
        ListNode move = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val < head2.val) {
                move.next = head1;
                head1 = head1.next;
            }else{
                move.next = head2;
                head2 = head2.next;

            }
            move = move.next;
        }

        if (head1 != null) {
            move.next = head1;
            head1 = head1.next;
        }

        if (head2 != null) {
            move.next = head2;
            head2 = head2.next;
        }

        return dummy.next;
    }
}
