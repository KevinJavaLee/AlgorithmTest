package com.kevin.Code.LinkNode;

import java.util.HashMap;

/**
 *   @author Vinlee xiao
 *   @Description: Leetcode 141. 环形链表 简单题型
 *   @create 2021-04-09 20:08
 *   @project LeetCode
 *   @Version 1.0
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    /**
     * @Description Leetcode 141. 环形链表
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        HashMap<ListNode,Integer> hashMap = new HashMap<>();

        ListNode move = head;

        while (move != null) {
            if (hashMap.get(move) != null) {
                return true;
            }
            hashMap.put(move, 1);
            move = move.next;
        }

        return false;
    }
}
