package com.kevin.Code.LinkNode;

import java.util.HashMap;

/**
 * @author Vinlee xiao
 * @Description: 剑指 Offer 35. 复杂链表的复制  中等难度
 * @create 2021-04-09 22:25
 * @project LeetCode
 * @Version 1.0
 */
public class CopyRandomList {
    public static void main(String[] args) {

    }

    /**
     * 复杂链表的复制 利用hashMap表思想
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node move = head;
        //哑节点
//        Node dummy = new Node(0);
        //定义一个hash表用于记录链表节点中的索引和其地址
        HashMap<Node, Node> hashMap = new HashMap<>();

        //先将节点全部放入hash表中
        while (move != null) {
            hashMap.put(move, new Node(move.val));
            move = move.next;
        }
        move = head;
        //将move重新置为头节点
        while (move != null) {
            hashMap.get(move).next = hashMap.get(move.next);
            hashMap.get(move).random = hashMap.get(move.random);
            move = move.next;
        }


        return hashMap.get(head);
    }
}
