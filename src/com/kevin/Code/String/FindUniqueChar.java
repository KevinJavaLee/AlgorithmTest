package com.kevin.Code.String;

import java.util.HashMap;

/**
 * @author Vinlee Xiao
 * @Classname FindUniqueChar
 * @Description 剑指 Offer 50. 第一个只出现一次的字符 简单
 * @Date 2021/8/13 19:24
 * @Version 1.0
 */
public class FindUniqueChar {

    public static char firstUniqChar(String s) {
        int len = s.length();
        HashMap<Character, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (hashmap.get(ch) == 1) {
                return ch;
            }
        }

        return ' ';
    }
}
