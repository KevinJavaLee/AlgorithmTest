package com.kevin.Code.Stack;

import java.util.Deque;
import java.util.Stack;

/**
 * @author Vinlee Xiao
 * @Classname ValidateStackSequences
 * @Description Leetcode 946. 验证栈序列 中等难度 同剑指Offer 31 经提醒有思路
 * @Date 2021/9/3 9:21
 * @Version 1.0
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 3, 5, 1, 2};
        boolean b = validateStackSequences(pushed, poped);
        System.out.println(b);
    }


    /**
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        //1.辅助栈
        Stack<Integer> helper = new Stack<>();

        int len = pushed.length;
        if (len == 0) {
            return false;
        }
        //
        int pushIndex = 0;
        int popIndex = 0;

        while (pushIndex < len) {


            helper.add(pushed[pushIndex]);
            pushIndex++;
            while (!helper.isEmpty() && helper.peek() == popped[popIndex]) {

                helper.pop();
                popIndex++;

            }


        }


        if (!helper.isEmpty()) {
            return false;
        }

        return true;
    }

}
