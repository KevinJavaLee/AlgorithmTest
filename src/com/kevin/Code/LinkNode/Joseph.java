package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: TODO
 * @create 2021-04-14 17:22
 * @project LeetCode
 * @Version 1.0
 */
public class Joseph {
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
        head4.next = head;
        ListNode node = getLastNode(head, 3);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 方法一：常规思路
     * @return
     */
    public static ListNode getLastNode(ListNode head,int m) {

        if (head.next == null || head==null) {
            return head;
        }

        ListNode move  = head;
        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;
        int cnt = 1;
        boolean flag = true;
        while (move != move.next) {

            if (cnt == m ) {
                pre.next = move.next;
                cnt=0;
                flag = false;
            }
            if (flag) {
                pre = pre.next;
            }
            flag = true;
            move = move.next;
            cnt++;
        }

        return head;
    }

    /**
     * 约瑟夫算法的改进：
     * @param head
     * @param m
     * @return
     */
    public static ListNode getLastNode1(ListNode head,int m){
        return null;
    }
}
