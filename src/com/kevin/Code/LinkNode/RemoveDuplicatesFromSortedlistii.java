package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: Leetcode82. 删除排序链表中的重复元素 II 简单题型
 * @create 2021-04-14 21:15
 * @project LeetCode
 * @Version 1.0
 */
public class RemoveDuplicatesFromSortedlistii {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        ListNode node = deleteDuplicates(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode move = dummy;
        /**
         *
         */
        while (move.next != null && move.next.next != null) {

            if (move.next.val == move.next.next.val) {

                int num = move.next.val;
                //找到和num相同的元素
                while (move.next!=null && move.next.val == num) {
                    move.next = move.next.next;
                }

            }else {
                move = move.next;
            }

        }

        return dummy.next;
    }
}
