package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: 面试02.05链表求和 类似Leetcode第二题
 * @create 2021-04-10 10:45
 * @project LeetCode
 * @Version 1.0
 */
public class SumList {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int sum = 0;
        //余数
        int reminder = 0;
        //除数
        int devider = 0;
        ListNode lHead = null;
        while (l1 != null && l2 != null) {

            //求两个节点的和
            sum = l1.val + l2.val + devider;

            devider = sum / 10;
            reminder = sum % 10;

            l1.val = reminder;

            if (l1.next == null) {
                lHead = l1;
            }
            l1 = l1.next;

            l2 = l2.next;
        }


        //如果l1不为空
        while (l1 != null) {
            sum = l1.val + devider;
            devider = sum / 10;
            reminder = sum % 10;

            l1.val = reminder;
            if (l1.next == null) {
                lHead = l1;
            }
            l1 = l1.next;

        }
        while (l2 != null) {
            sum = l2.val + devider;
            devider = sum /10;
            reminder = sum % 10;


            ListNode tmp = new ListNode(reminder);
            lHead.next = tmp;
            lHead = lHead.next;

            l2 = l2.next;

        }


        if (devider != 0) {
            ListNode node = new ListNode(devider);
            lHead.next = node;
            lHead = lHead.next;
        }

        return head;

    }
}
