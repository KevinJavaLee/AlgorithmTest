package com.kevin.Code.SortArray;

import java.util.Arrays;

/**
 * @Project LeetCode
 * @ClassName ValidAnagram
 * @Description Leetcode 242题 有效的字母异位词 简单题
 * @Author Vinlee Xiao
 * @Date 2021/05/04/19:26
 * @Version 1.0
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

        boolean b = isAnagram(s1, s2);
        System.out.println(b);
    }

    /**
     * 思路1：进行排序后，比较两个字母是否相同
     * 思路2：哈希表
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        int len = s.length();
        int difference = Math.abs(s.length()-t.length());

        if (difference != 0) {
            return false;
        }
        char[] ch = s.toCharArray();
        char[] ch1 = t.toCharArray();
//        char[] ch = new char[s.length()];
//        char[] ch1 = new char[t.length()];
//
//        for (int i = 0; i < len; i++) {
//            ch[i] = s.charAt(i);
//            ch1[i] = t.charAt(i);
//        }

        //进行排序
        Arrays.sort(ch);
        Arrays.sort(ch1);

//        String s1 = Arrays.toString(ch);
//        String s2 = Arrays.toString(ch1);
//
//        if (s1.equals(s2)) {
//            return true;
//        }

        return Arrays.equals(ch,ch1);
    }
}
