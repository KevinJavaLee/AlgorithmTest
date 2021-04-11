package com.kevin.Code.LinkNode;


import java.util.*;

/**
 * @author Vinlee xiao
 * @Description: Leetcode 148. 排序链表 重点题
 * @create 2021-04-11 19:23
 * @project LeetCode
 * @Version 1.0
 */
public class SortList {
    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(2);
        head.next = head1;
        head1.next = head2;
//        head2.next = head3;
        ListNode node = sortList2(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
    public static ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1, null);
        ListNode move = head;
        if (head == null || head.next == null) {
            return head;
        }

        Deque<ListNode> deque = new LinkedList<>();
        Stack<ListNode> help = new Stack<>();
        while (move != null) {

            while (!deque.isEmpty() && move.val < deque.peekLast().val) {

                ListNode node = deque.pollLast();
//                System.out.println("node:" + node.val);
                help.push(node);
            }
//            System.out.println("Move:" + move.val);
            deque.addLast(move);
            while (!help.isEmpty()) {
                deque.addLast(help.pop());
            }
            move = move.next;
        }
//        while (!deque.isEmpty()) {
//            System.out.println("deque:" + deque.pollFirst().val);
//
//        }
        ListNode moveDummy = dummy;
//        //仅需排序
        while (!deque.isEmpty()) {
            moveDummy.next = deque.pollFirst();
            moveDummy = moveDummy.next;
        }

        moveDummy.next = null;
        return dummy.next;

    }

    public static ListNode sortList1(ListNode head) {
        ListNode move = head;
        ListNode nextNode = head;

        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList();
        while (move != null) {
            list.add(move.val);
            move = move.next;
        }
        list.sort((x,y)->Integer.compare(x,y));
        int cnt = 0;
        while (nextNode != null) {
            nextNode.val = list.get(cnt);
            cnt++;
            nextNode = nextNode.next;
        }


        return head;

    }

    /**
     * Leetcode官方题解归并排序 重点题
     * @param head
     * @return
     */
    public static  ListNode sortList2(ListNode head) {



        return sortList(head,null);

    }

    /**
     *
     * @param head
     * @param tail
     * @return
     */
    public static ListNode sortList(ListNode head, ListNode tail) {

        //
        if (head == null) {
            return head;
        }
        //只有一个节点
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode low = head;
//        System.out.println(head.val);
        //块慢指针来找到中点
        int cnt = 0;
        while (fast != tail) {
            cnt++;
            fast = fast.next;
            low = low.next;
//            System.out.println("fast:" +fast.val);

//            System.out.println("low:" + low.val);
//            System.out.println("cnt"+cnt);
            if (fast != tail) {
                fast = fast.next;
//                System.out.println("slow:" + fast.val);
            }
        }
        ListNode mid = low;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);

        ListNode sum = mergeTwoOrderList(list1, list2);


        return sum ;
    }

    /**
     * 合并两个有序列表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoOrderList(ListNode l1, ListNode l2) {
        ListNode head1 = l1,head2 = l2;


        ListNode dummy = new ListNode(-1,l1);
        ListNode move = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val < head2.val) {
                move.next = head1;
                head1 = head1.next;
            }else{
                move.next = head2;
                head2 = head2.next;

            }
            move = move.next;
        }
        if (head1 != null) {
            move.next = head1;
            head1 = head1.next;
        }

        if (head2 != null) {
            move.next = head2;
            head2 = head2.next;
        }

        return dummy.next;
    }


}
