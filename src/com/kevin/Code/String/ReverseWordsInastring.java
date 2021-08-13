package com.kevin.Code.String;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Vinlee Xiao
 * @Classname ReverseWordsInastring
 * @Description Leetcode 151. 翻转字符串里的单词 同剑指 Offer 58 - I. 翻转单词顺序 中等难度
 * @Date 2021/8/13 19:31
 * @Version 1.0
 */
public class ReverseWordsInastring {
    public static void main(String[] args) {
        String s = reverseWords(" ");
        System.out.println(s);
    }


    /**
     * 双指针解决问题 "  hello world!  "
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        //用于保存字符串

        ArrayList<String> list = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return new String("");
        }
//        System.out.println(len);
        //定位第一个出现空格的位置
        int left = len - 1;
        int right = left;

        while (left > 0) {
//            System.out.println(1);
            if (s.charAt(left) != ' ') {
                right = left;
                while (right > 0 && s.charAt(right) != ' ') {
                    right--;
//                    System.out.println("right-"+right);
                }
                list.add(s.substring(left, right));
//                System.out.println("right:"+right);
                left = right;

            }
            left++;

        }

        StringBuilder builder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            builder.append(list.get(size - 1 - i) + " ");
        }

        if (size != 0) {
            builder.append(list.get(0));
        }


        return builder.toString();
    }

}
