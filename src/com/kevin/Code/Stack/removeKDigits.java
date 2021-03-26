package com.kevin.Code.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第402题 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小
 * @create 2021-03-24 11:08
 * @project LeetCode
 * @Version 1.0
 */
public class removeKDigits {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        String s = removeKdigits(num, k);
        System.out.println(s);
    }


    /**
     * 贪心算法和单调栈
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {

        int len = num.length();
        //队列
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < len; i++) {

            int d = num.charAt(i) - '0';

            while (!deque.isEmpty() && k > 0 && deque.peekLast() > d) {
                deque.pollLast();
                k--;
            }

            deque.addLast(d);
        }

        //从栈尾弹出数据
        while (k > 0) {
            k--;
            deque.pollLast();
        }

        /*如果最终的数字序列存在前导零，我们要删去前导零。
        如果最终数字序列为空，我们应该返回 00
        * */
        boolean isPreviouZero = true;
        StringBuffer buffer = new StringBuffer();

        while (!deque.isEmpty()) {

            int ch = deque.pollFirst();
            if (isPreviouZero && ch == 0) {
                continue;
            }
            isPreviouZero = false;
            buffer.append(ch);

        }
        //如果数字序列为空则，返回零
        if (buffer.length() == 0) {
            return "0";
        }
        //
        return buffer.toString();
    }
}
