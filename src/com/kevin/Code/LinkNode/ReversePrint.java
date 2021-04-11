package com.kevin.Code.LinkNode;


import java.util.Arrays;

/**
 * @author Vinlee xiao
 * @Description: 剑指 Offer 06
 * @create 2021-03-26 16:49
 * @project LeetCode
 * @Version 1.0
 */
public class ReversePrint {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head.next = head1;
        head1.next = head2;

        int[] nums = reversePrint(head);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] reversePrint(ListNode head) {

        int []arr = new int[10000];

        int index = 0;
        while (head != null) {
            arr[index] = head.val;
            head = head.next;
            index++;
        }
        int []result = new int[index];
        //对数组的数据进行翻转
        for (int i = 0; i < index; i++) {
            result[i] = arr[index-1-i];
        }

        return result;
    }
}
