package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-09-7:43
 */




public class mergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        ListNode  l2 = new ListNode(2);
        l2.next = new ListNode(3);

        ListNode node = mergeTwoLists(l1,l2);
        System.out.println(node);
    }

    /*合并连个有序列表*/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /*定义一个新的ListNode*/
        ListNode newNode = new ListNode(-1);
        ListNode preNode = newNode;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                preNode.next = l1;
                l1 = l1.next;

            }else {
                preNode.next = l2;
                l2 = l2.next;
            }

            /*移动preNode到preNode的下一个结点*/
            preNode = preNode.next;
        }

        /**/
        if (l1 == null && l2 !=null) {
            preNode.next = l2;
        }
        if (l1 != null && l2 == null) {
            preNode.next = l1;
        }


        return newNode.next;
    }
}
