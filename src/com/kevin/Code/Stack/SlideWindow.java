package com.kevin.Code.Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee xiao
 * @Description: 剑指59题 滑动窗口的最大值
 * @create 2021-03-12 10:29
 * @project LeetCode
 * @Version 1.0
 */
public class SlideWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //双端队列
        Deque<Integer> deque = new LinkedList<>();

        int index = 0;
        if (nums==null||nums.length==0 || k==0) {
            return new int[0];
        }
        //建立一个存储滑动窗口最大值的数组
        int[] res = new int[nums.length - k + 1];



        for (int i = 0; i < nums.length; i++) {

            //如果队列中存储的下标所对应的值小于或者等于num[i]，则把对胃的下标弹出
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //向队列的尾部插入数据
            deque.addLast(i);
            //下标过期
            if (!deque.isEmpty()&& i - k ==deque.peekFirst()) {
                deque.pollFirst();
            }

            //队列头部存储的都是每个窗口最大的元素
            //当下标超过窗口的大小所对应的下标时，会有新的最大值加入到队列中
            if (i >= k - 1) {
                //把双端队列头部存储的下标放到
                res[index] = nums[deque.peekFirst()];
                index++;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{};
        int k = 0;
        int[] nums = maxSlidingWindow(arr, k);

        System.out.println(Arrays.toString(nums));
    }
}
