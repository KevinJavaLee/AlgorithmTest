package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: Leetcode中等1669 合并链表
 * @create 2021-04-09 21:23
 * @project LeetCode
 * @Version 1.0
 */
public class MergeInBetween {
    public static void main(String[] args) {

        ListNode left1 = new ListNode(0);
        ListNode left2 = new ListNode(1);
        ListNode left3 = new ListNode(2);
        ListNode left4 = new ListNode(3);
        ListNode left5 = new ListNode(4);
        ListNode left6 = new ListNode(5);
        left1.next = left2;
        left2.next = left3;
        left3.next = left4;
        left4.next = left5;
        left5.next = left6;

        ListNode right1 = new ListNode(1000);
        ListNode right2 = new ListNode(1001);
        ListNode right3 = new ListNode(1002);
        right1.next = right2;
        right2.next =right3;

        ListNode node = mergeInBetween(left1, 3, 4, right1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    /**
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode head2 = list2;
        ListNode tail2 = null;
        ListNode head1 = list1;
        ListNode tail1 = null;
        ListNode preNode = null;
        while (list2.next != null) {
            list2 = list2.next;
        }
        //得到list2的为节点
        tail2 = list2;
        int cnt = 0;
        while (list1 != null) {

            if (cnt == a - 1) {
                preNode = list1;
            }
            cnt++;
            if (cnt == b + 2) {
                tail1 = list1;
                break;
            }
            list1 = list1.next;
        }

        //连接链表
        preNode.next = head2;
        tail2.next = tail1;

        return head1;
    }
}
