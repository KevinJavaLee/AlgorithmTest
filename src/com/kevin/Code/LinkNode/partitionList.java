package com.kevin.Code.LinkNode;

/**
 * @Project LeetCode
 * @ClassName partitionList
 * @Description 86. 分隔链表 Leetcode 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/23/22:29
 * @Version 1.0
 */
public class partitionList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(4);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(2);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode node = partition(head, 3);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 两个链表一个链表只连接小于x的结点
     * 一个链表只连接大于x的结点
     * @param head
     * @param x
     * @return
     */
    public static ListNode  partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode small = new ListNode(0, null);
        ListNode smallMove = small;
        ListNode big = new ListNode(0, null);
        ListNode bigMove = big;
        ListNode move = head;

        while (move != null) {

            if (move.val < x) {
                smallMove.next = move;
                smallMove = smallMove.next;
            }else {
                bigMove.next = move;
                bigMove = bigMove.next;
            }

//            bigMove.next = null;
            move = move.next;
        }

        bigMove.next = null;
        //将小结点的末尾连接到大结点链表的头结点

        smallMove.next = big.next;


        return small.next;
    }
}
