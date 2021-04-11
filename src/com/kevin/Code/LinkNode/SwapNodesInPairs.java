package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: Leetcode中等24题两两交换链表中的结点
 * @create 2021-04-11 9:45
 * @project LeetCode
 * @Version 1.0
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;


        ListNode node = swapPairs(head);


        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //声明一个哑结点
        ListNode dummy = new ListNode(-1, head);
        ListNode move = dummy;


        while (move.next != null && move.next.next != null) {
            ListNode node1 = move.next;
            ListNode node2 = move.next.next;

            move.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            move = node1;

        }


        return dummy.next;
    }
}
