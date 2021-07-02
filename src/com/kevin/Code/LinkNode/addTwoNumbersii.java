package com.kevin.Code.LinkNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Project LeetCode
 * @ClassName addTwoNumbersii
 * @Description 445. 两数相加 II Leetcode 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/25/16:47
 * @Version 1.0
 */
public class addTwoNumbersii {
    public static void main(String[] args) {
        ListNode left1 = new ListNode(9);
        ListNode left2 = new ListNode(1);
        ListNode left3 = new ListNode(6);
//        ListNode left4 = new ListNode(3);
        left1.next = left2;
        left2.next = left3;
//        left3.next = left4;

        ListNode right1 = new ListNode(0);
//        ListNode right2 = new ListNode(6);
//        ListNode right3 = new ListNode(4);
//        right1.next = right2;
//        right2.next =right3;

        ListNode node = addTwoNumbers(left1, right1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 栈的思想
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        ListNode move1 = l1;
        ListNode move2 = l2;
        ListNode dummy = null;
        ListNode move = dummy;
        while (move1 != null && move2 != null) {
            stack1.addLast(move1.val);
            stack2.addLast(move2.val);
            move1 = move1.next;
            move2 = move2.next;
        }
        while (move1 != null) {
//            System.out.println("move1:" + move1.val);
            stack1.addLast(move1.val);
            move1 = move1.next;
        }

        //
        while (move2 != null) {
            stack2.addLast(move2.val);
            move2 = move2.next;
        }

        int reminder = 0;
        int carry = 0;
        int sum = 0;
        //出栈动作
        boolean flag = true;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum =stack1.pollLast() + stack2.pollLast();
            reminder = (sum + carry) %10;
            carry = (sum + carry)/10;
            ListNode node = new ListNode(reminder);
            node.next = move;
            move = node;

        }

        while (!stack1.isEmpty()) {

            sum = stack1.pollLast();
            reminder = (sum + carry) %10;
            carry = ( sum+ carry)/10;

            ListNode node = new ListNode(reminder);
            node.next = move;
            move = node;
        }

        while (!stack2.isEmpty()) {
            sum = stack2.pollLast();
            reminder = (sum + carry) %10;
            carry = ( sum+ carry)/10;
            ListNode node = new ListNode(reminder);
            node.next = move;
            move = node;

        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = move;
            move = node;
        }
        return move;
    }
}
