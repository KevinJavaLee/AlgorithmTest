package com.kevin.Code.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee xiao
 * @Description: TODO Leetcode 第1544题 整理字符串
 * 用栈来
 * @create 2021-03-18 21:57
 * @project LeetCode
 * @Version 1.0
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {

        String s = "abBAcC";
        String s1 = makeGood(s);
        System.out.println(s1);

    }


    /**
     * 整理字符串 用栈的思想来解决
     * @param s
     * @return
     */
    public static String makeGood(String s) {

        int len = s.length();
        //用队列
        Deque<Character> deque = new LinkedList<>();


        //如果字符与队尾的元素变换相同则不加入且弹出队尾

        for (int i = 0; i < len; i++) {

            Character ch = s.charAt(i);

            if (!deque.isEmpty()) {
                Character temp = deque.peekLast();
                if (Character.isUpperCase(ch) && Character.isLowerCase(temp) && Character.toUpperCase(temp) == ch) {
                    deque.pollLast();
                    continue;
                } else if (Character.isLowerCase(ch) && Character.isUpperCase(temp) && Character.toUpperCase(ch) == temp) {
                    deque.pollLast();
                    continue;
                }

            }

            deque.addLast(ch);
        }

        StringBuffer stringBuffer = new StringBuffer();

        while (!deque.isEmpty()) {

            stringBuffer.append(deque.pollFirst());
        }


        return stringBuffer.toString();
    }
}
