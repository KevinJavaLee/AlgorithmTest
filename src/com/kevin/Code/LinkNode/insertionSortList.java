package com.kevin.Code.LinkNode;

/**
 * @Project LeetCode
 * @ClassName insertionSortList
 * @Description 147. 对链表进行插入排序 Leetcode中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/23/21:16
 * @Version 1.0
 */
public class insertionSortList {
    public static void main(String[] args) {
        ListNode left1 = new ListNode(-1);
        ListNode left2 = new ListNode(5);
        ListNode left3 = new ListNode(3);
        ListNode left4 = new ListNode(4);
        ListNode left5 = new ListNode(0);

        left1.next = left2;
        left2.next = left3;
        left3.next = left4;
        left4.next = left5;
        ListNode node = insertionSortList(left1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

//        if (head.next == null) {
//            return head;
//        }

        ListNode dummy  = new ListNode(0,head);
        //移动到第二个结点
        ListNode move = head.next;
        ListNode pre = head;
        ListNode preMove = dummy;

        while (move != null) {

            while (preMove.next != move) {
                //
                if (preMove.next.val >= move.val) {
                    pre.next = move.next;
                    move.next = preMove.next;
                    preMove.next = move;
                    move = pre;
                    break;
                }
                preMove = preMove.next;
            }
            //每次都要初始化为哑结点
            preMove = dummy;
            if (move != pre) {
                pre = pre.next;
            }
            move = move.next;
        }



        return dummy.next;
    }
}
