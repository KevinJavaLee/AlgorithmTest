package com.kevin.Code.LinkNode;

/**
 * @Project LeetCode
 * @ClassName palindromeLinkedlist
 * @Description 234. 回文链表 用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/27/21:01
 * @Version 1.0
 */
public class palindromeLinkedlist {
    public static void main(String[] args) {
        ListNode left1 = new ListNode(1);
        ListNode left2 = new ListNode(0);
        ListNode left3 = new ListNode(0);
//        ListNode left4 = new ListNode(1);

        left1.next = left2;
        left2.next = left3;
//        left3.next = left4;

        boolean b = isPalindrome(left1);
        System.out.println(b);
    }

    /**
     * 改进做法：方法二快慢指针把链表的右半部分压入栈 算法空间复杂度：O(N) 时间复杂度O(N)
     * 改进做法1:方法三改变链表的右半区的结构，使整个右半区反转指向中间节点
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        //第一步：找到中间结点 快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
//            System.out.println("i");
        }

        //右分区的
        fast = slow.next; //右分区的第一个结点
        slow.next = null;
        ListNode help = null;

        while (fast != null) {
            help = fast.next;
            fast.next = slow;
            slow = fast;
            fast = help;
        }

        //保存最后一个结点
        fast = slow;
        slow = head;

        //从头尾结点分别向两端遍历
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }


        return true;
    }
}
