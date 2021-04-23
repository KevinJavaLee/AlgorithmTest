package com.kevin.Code.LinkNode;

import java.util.HashSet;

/**
 * @Project LeetCode
 * @ClassName Linkedlistcycleii
 * @Description 142. 环形链表 II 中等难度 题目要求使用o(1)空间
 * @Author Vinlee Xiao
 * @Date 2021/04/20/23:02
 * @Version 1.0
 */
public class Linkedlistcycleii {
    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(0);
        ListNode head3 = new ListNode(-4);
//        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head1;

        ListNode node = detectCycle(head);

        System.out.println(node.val);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }

    }

    /**
     * HashSet写法 题目要求O(1)空间使用hash表不能满足要求
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {

        ListNode move = head;
        if (head == null || head.next == null) {
            return null;
        }

        HashSet<ListNode> hashSet = new HashSet<>();

        while (move != null) {
            if (!hashSet.add(move)) {
                return move;
            }
            move = move.next;
        }

        return null;
    }

    /**
     * 快慢指针求法和求链表第一个公共点做法相似
     * fast与slow。它们起始都位于链表的头部。随后slow 指针每次向后移动一个位置，
     * 而fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与slow 指针在环中相遇
     * @param head
     * @return
     */
    public static ListNode detectCyclePlus(ListNode head){

        ListNode slow = head,fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast!= null) {
                fast = fast.next;
            }else {
                return null;
            }

            //如果快指针和慢指针相遇
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }

        return null;
    }
}
