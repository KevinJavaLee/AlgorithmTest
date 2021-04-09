package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第2题两数相加
 * @create 2021-04-09 20:08
 * @project LeetCode
 * @Version 1.0
 */
public class AddTwoNumber {
    public static void main(String[] args) {

        ListNode left1 = new ListNode(9);
        ListNode left2 = new ListNode(9);
        ListNode left3 = new ListNode(9);
        ListNode left4 = new ListNode(9);
        ListNode left5 = new ListNode(9);
        ListNode left6 = new ListNode(9);
        ListNode left7 = new ListNode(9);


        left1.next = left2;
        left2.next = left3;
        left3.next = left4;
        left4.next = left5;
        left5.next = left6;
        left6.next = left7;


        ListNode right1 = new ListNode(9);
        ListNode right2 = new ListNode(9);
        ListNode right3 = new ListNode(9);
        ListNode right4 = new ListNode(9);
        right1.next = right2;
        right2.next =right3;
        right3.next = right4;
//
        ListNode node = addTwoNumbers(left1, right1);


        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
//          while (left1 != null) {
//            System.out.println(left1.val);
//            left1 = left1.next;
//        }
    }


    /**
     *
     * @param l1
     * @param l2
     * @return
     */
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
