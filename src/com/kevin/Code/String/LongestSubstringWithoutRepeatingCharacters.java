package com.kevin.Code.String;

import java.util.HashMap;

/**
 * @author Vinlee Xiao
 * @Classname LongestSubstringWithoutRepeatingCharacters
 * @Description 剑指 Offer 48. 最长不含重复字符的子字符串 同Leetcode 3 没啥思路
 * @Date 2021/8/18 21:07
 * @Version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String s = " ";
//        s.charAt(0);
        int substring = lengthOfLongestSubstring("dvdf");
        System.out.println(substring);
    }


    /**
     * "abcabcbb" "bbbbb" "pwwkew"
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

//        String s1 = s.replaceAll(" ", "");
        int maxSize = 0;
        int size = s.length();
        if (size == 0) {
            return 0;
        }
        //用于记录每个字符出现的次数
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = -1;
        int right = 0;
        int subSize = 0;

        while (right < size) {

            if (hashMap.containsKey(s.charAt(right))) {
                left = Math.max(left, hashMap.get(s.charAt(right)));
            }
            hashMap.put(s.charAt(right), right);
            maxSize = Math.max(maxSize, right - left);
            right++;
        }


        return maxSize;
    }

    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        return 0;
    }
}
