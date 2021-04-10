package com.kevin.Code.LinkNode;

import java.util.ArrayList;

/**
 * @author Vinlee xiao
 * @Description: Leetcode1721. 交换链表中的节点
 * @create 2021-04-10 10:50
 * @project LeetCode
 * @Version 1.0
 */
public class SwapNodesLinkedList {
    public static void main(String[] args) {


        ListNode left1 = new ListNode(1);
        ListNode left2 = new ListNode(2);
//        ListNode left3 = new ListNode(6);
//        ListNode left4 = new ListNode(6);
//        ListNode left5 = new ListNode(7);
//        ListNode left6 = new ListNode(8);
//        ListNode left7 = new ListNode(3);
//        ListNode left8 = new ListNode(0);
//        ListNode left9 = new ListNode(9);
//        ListNode left10 = new ListNode(5);

        left1.next = left2;
//        left2.next = left3;
//        left3.next = left4;
//        left4.next = left5;
//        left5.next = left6;
//        left6.next = left7;
//        left7.next = left8;
//        left8.next = left9;
//        left9.next = left10;

        ListNode node = swapNodes(left1, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 5-2*i + 1
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode swapNodes(ListNode head, int k) {

//        if (k == 1) {
//            return head;
//        }

        ListNode move = head;
        ListNode move1 = head;

        //新建一个数组用于
        ArrayList<Integer> list = new ArrayList<>();
        int len = 0;


        while (move != null) {
            len++;
            list.add(move.val);
            move = move.next;
        }

        int tmpIndex = len - 2 * k + 1;

        //记录交换的是左边第几个数
        int rightIndex = k + tmpIndex;

        int cnt = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        while (move1 != null ) {
            cnt++;

            if (cnt == k) {
                move1.val = list.get(rightIndex-1);
                flag1 = true;
            }else if (cnt == rightIndex) {
                move1.val = list.get(k-1);
                flag2 = true;
            }


            if (flag1 && flag2) {
                break;
            }
            move1 = move1.next;
        }


        return head;
    }
}
