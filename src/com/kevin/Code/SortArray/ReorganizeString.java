package com.kevin.Code.SortArray;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Project LeetCode
 * @ClassName ReorganizeString
 * @Description Leetcode 第767题 重构字符串 中等难度 没思路 贪心思想 基于堆的贪心
 * @Author Vinlee Xiao
 * @Date 2021/05/04/19:21
 * @Version 1.0
 */
public class ReorganizeString {
    public static void main(String[] args) {
        String s = "aaab";
        String s1 = reorganizeString(s);
        System.out.println(s1);
    }

    /**
     * 题解：参考Leetcode官方题解 基于最大堆的贪心
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {

        if (S.length() < 2) {
            return S;
        }
        char[] count = new char[26];
        //统计字符串中出现次数最多的字符出现的次数
        int maxCount = 0;

        //统计字符串中每个字母的出现次数
        for (int i = 0; i < S.length(); i++) {
            int ch = S.charAt(i)-'a';
            count[ch]++;
            maxCount = Math.max(maxCount,count[ch]);

        }
        //如果字符串中出现次数最大的字符超过字符长度的一半，则无法组成相邻字符不相同的字符串
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }
        //构建优先队列 根据字符出现的次数构建优先队列
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2 - 'a'] - count[o1 - 'a'];
            }
        });

        //将字符出现的次数放进优先队列中
        for (char i = 'a'; i <= 'z'; i++) {

            if (count[i - 'a'] > 0) {
                priorityQueue.offer(i);
            }
        }


        //进行字符串的拼接
        StringBuffer buffer = new StringBuffer();
        while (priorityQueue.size() > 1) {

            //将队列中前两个出队
            char ch1 = priorityQueue.poll();
            char ch2 = priorityQueue.poll();
            //加入字符串中
            buffer.append(ch1 + "" +  ch2);
            int index1 = ch1-'a';
            int index2 = ch2-'a';

            count[index1]--;
            count[index2]--;

            //字符出现的次数大于0
            if (count[index1] > 0) {
                priorityQueue.offer(ch1);
            }

            if (count[index2] > 0) {
                priorityQueue.offer(ch2);
            }

        }
        //如果字符是奇数还要去一次字符才能构成最终的字符串
        if (priorityQueue.size() > 0) {
            buffer.append(priorityQueue.poll());
        }

        return buffer.toString();
    }



}
