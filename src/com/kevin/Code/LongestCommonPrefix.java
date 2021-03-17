package com.kevin.Code;

import javax.sound.midi.SoundbankResource;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-15:34
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String longStr = commonPrefix("123","");
//        System.out.println(longStr);

        String []strings = new String[]{"flower","flow","flight"};
//        for (String string : strings) {
//            System.out.println(string);
//        }
        String longestCommonStr = longestCommonPrefix(strings);
        System.out.println("最长子串："+longestCommonStr);
    }


    /*纵向扫描数组*/
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        int length = strs[0].length();
//        int count = strs.length;
//        for (int i = 0; i < length; i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < count; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }

    public static String longestCommonPrefix(String[] strs){


        int len = strs.length;
        /*如果有字符串长度为1直接返回空*/
        if (len == 0) {
            return "";
        }
        /*1.横向扫面数组*/
        String prefix = strs[0];
//        System.out.println(prefix);
        /*2.求出字符串数组的长度*/



        for (int i = 1; i < len; i++) {

            prefix = commonPrefix(prefix,strs[i]);

        }
//        System.out.println(prefix);
        /*1.如果判断的字符数组为空*/

        if (prefix.length() == 0) {
//            System.out.println(1);
            return "";
        }

        return prefix;

    }


    /**
     *
     * @param str1
     * @param str2
     * @return
     * 找出两个字符串的最长公共子串
     */
    public static String commonPrefix(String str1, String str2) {


        /*1.先求出两个字符串最短的一位长度*/
        int minLength = Integer.min(str1.length(),str2.length());
        //如果有字符串的长度为0 直接返回空串
        if (minLength == 0) {
            return "";
        }
        int commonIndex = 0;//用于记录最长的公共子串下标
        for (int i = 0; i < minLength; i++) {


            if (str1.charAt(i) != str2.charAt(i)) {
                break;

            }
            commonIndex++;
        }

        if (commonIndex == 0) {
            return "";
        }

        //返回

        return str1.substring(0,commonIndex);
    }

}
