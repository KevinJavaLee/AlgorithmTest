package com.kevin.Code.String;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname StringPermutation
 * @Description 剑指 Offer 38. 字符串的排列 中等难度 回溯 没啥思路 看题解才有思路
 * @Date 2021/8/13 21:45
 * @Version 1.0
 */
public class StringPermutation {
    LinkedList<String> res = new LinkedList<>();
    char[] ch;

    /**
     * abc
     * "abc","acb","bac","bca","cab","cba"
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {

        ch = s.toCharArray();
//        System.out.println(ch.length);
        dfs(0);
        String[] str = res.toArray(new String[res.size()]);
//        System.out.println(str.length);
        return str;
    }

    /**
     * 表示字符串的位置
     *
     * @param i
     */
    private void dfs(int i) {

        //递归中止的条件
        if (i == ch.length - 1) {
//            System.out.println(ch);
            //将字符数组转换为字符串
            res.add(String.valueOf(ch));
            return;
        }

        //建立一个HashSet用于过滤掉重复的值
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < ch.length; j++) {

            //1.如果字符已经在set中出现，则跳过
            if (set.contains(ch[j])) {
                continue;
            }
            set.add(ch[j]);
            //交换数据
            swap(j, i);
            dfs(i + 1);
            //恢复数据原来的样子
            swap(j, i);
        }
    }

    private void swap(int a, int b) {
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
}
