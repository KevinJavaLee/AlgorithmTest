package com.kevin.Code.Array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Project LeetCode
 * @ClassName MoveZeroes
 * @Description Leetcode283 移动零 简单 中频 双指针的思路
 * @Author Vinlee Xiao
 * @Date 2021/05/22/9:41
 * @Version 1.0
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        moveZeroes1(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /**
     *思路1：遍历一次
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                deque.addLast(nums[i]);
                cnt++;
            }
        }

        for (int j = 0; j < len; j++) {
            if (j < cnt) {
                nums[j] = deque.pollFirst();
            }else {
                nums[j] = 0;
            }
        }
    }

    //
    public static void moveZeroes1(int[] nums) {
        int len = nums.length;
        int cnt = 0;
//        if (len == 1) {
//            return;
//        }
        for (int i = 0; i < len; i++) {

            if (nums[i] != 0) {
                nums[cnt] = nums[i];
                cnt++;
            }
        }

        for (int j = len - 1; j >= cnt; j--) {
            nums[j] = 0;
            System.out.println("--");
        }
    }

    //题解双指针法：
    //0,1,0,3,12
    //左指针左边均为非0数，右指针指向待处理的数据
    //左指针指向已经处理好的数据的尾部，右指针待处理的数
    public static void moveZeroes2(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;


        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    /**
     * 交换两个数
     * @param nums
     * @param left
     * @param right
     */
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
