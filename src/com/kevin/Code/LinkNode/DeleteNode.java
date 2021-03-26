package com.kevin.Code.LinkNode;

import java.util.List;

/**
 * @author Vinlee xiao
 * @Description: 剑指 Offer 18. 删除链表的节点
 * @create 2021-03-26 17:20
 * @project LeetCode
 * @Version 1.0
 */
public class DeleteNode {
    public static void main(String[] args) {
        //4,5,1,9
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(9);
//        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        ListNode node = deleteNode(head, 9);

        //遍历链表
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode deleteNode(ListNode head, int val) {

        ListNode move = head;
        ListNode pre = head;
        //用来记录该节点是不是头结点
        int flag = 0;

        while (move != null) {

            if (move.val == val) {

                //删除的是第一个节点
                if (flag == 0) {

                    head = head.next;
                    break;
                }else {
                    pre.next = move.next;
                    break;
                }
            }

            flag++;
            pre = move;
            move = move.next;


        }


        return head;

    }
}
