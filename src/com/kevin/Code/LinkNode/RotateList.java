package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: Leetcode61中等 61. 旋转链表
 * @create 2021-04-14 20:42
 * @project LeetCode
 * @Version 1.0
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(4);
//        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
//        head2.next = head3;
//        head3.next = head4;

        ListNode node = rotateRight(head, 4);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next==null) {
            return head;
        }
        ListNode tail = head;
        ListNode move = head;
        int cnt = 0;
        while (tail.next != null) {
            cnt++;
            tail = tail.next;
        }
        cnt++;

        int reminder = k % cnt;
        if (reminder == 0) {
            return head;
        }

        int moveNum =  cnt - reminder;
        ListNode newNode = null;
        while (move != null) {
            moveNum--;
            if (moveNum == 0) {
                 newNode = move.next;
                tail.next = head;
                move.next = null;
                break;
            }
            move = move.next;
        }

        return newNode;
    }
}
