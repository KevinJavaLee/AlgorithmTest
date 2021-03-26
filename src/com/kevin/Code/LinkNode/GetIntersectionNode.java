package com.kevin.Code.LinkNode;

/**
 * @author Vinlee xiao
 * @Description: 剑指 Offer 52. 两个链表的第一个公共节点 双指针
 * @create 2021-03-26 21:01
 * @project LeetCode
 * @Version 1.0
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode moveA = headA;
        ListNode moveB = headB;

        //
        if (headA == null || headB == null) {
            return null;
        }
        //如果两个相等 巧妙的方法
        while (moveA != moveB) {

            moveA = moveA != null ? moveA.next:headB;
            moveB = moveB != null ? moveB.next:headA;

        }





        return moveA;
    }
}
