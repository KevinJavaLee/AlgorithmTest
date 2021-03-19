package com.kevin.Code.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: Leetcode第316题和1081题
 * 思路：运用单调栈
 * @create 2021-03-18 18:58
 * @project LeetCode
 * @Version 1.0
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }

    /**
     * 思路：用两个栈来实现
     * @param s
     * @return
     */
    public  static String removeDuplicateLetters(String s) {

        int len = s.length();

        //建立一个hash数组用于判断字符在字符串中出现的最后下标
        int []index = new int[26];
//        int []isInArr = new int[26];
        StringBuffer buffer = new StringBuffer();

        //辅助队列
        Deque<Character> helpQueue = new LinkedList<>();


        for (int i = 0; i < len; i++) {

            //用于存储每个字符在数组中最后存储的位置
            index[s.charAt(i) - 'a'] = i;
        }

        //定义一个visited数组，用于存储字符是否已经在队列中
        boolean[] visited = new boolean[26];

        //遍历字符数组
        for (int i = 0; i < len; i++) {

            char ch = s.charAt(i);
            //如果该字符已经在栈中，则不需要将该元素加入到队列中
            if (visited[ch - 'a']) {
                continue;
            }


            //如果队列不为空且队列尾部的数据大于字符ch,以及队列顶部的字符在字符中出现的下标大于当前坐标
            while (!helpQueue.isEmpty() && helpQueue.peekLast() > ch && index[helpQueue.peekLast() - 'a'] > i) {

                char topCh = helpQueue.pollLast();
                visited[topCh - 'a'] = false;
            }

            //将元素加入到队列中
            helpQueue.addLast(ch);
            visited[ch-'a'] = true;

        }

        while (!helpQueue.isEmpty()) {

            buffer.append(helpQueue.pollFirst());
        }

        return  buffer.toString();

    }
}
