package com.kevin.Code.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第496题 下一个更大的元素
 * @create 2021-03-17 19:04
 * @project LeetCode
 * @Version 1.0
 */
public class NextGreatereElement {
    public static void main(String[] args) {

        int nums1[] = new  int[]{4,1,2};
        int nums2[] = new int[]{1,3,4,2};

        int[] nextMaxNum = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(nextMaxNum));

    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //用于存储第二个数组中所对应的下一个最大的数
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[nums1.length];

        //利用栈
        for (int i = 0; i < nums2.length ; i++) {

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {

                //hash表中保存着，这个元素的下一个更大的元素
                hashMap.put(stack.pop(),nums2[i]);

            }

            stack.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {

            Integer minNum = hashMap.get(nums1[i]);

            if (minNum == null) {
                arr[i] = -1;
            }else {
                arr[i] = minNum;
            }

        }

        return arr;
    }
}
