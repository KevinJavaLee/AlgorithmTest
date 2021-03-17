package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-14:56
 */
public class isPalindrome {


    public static void main(String[] args) {
        boolean palindrome = isPalindrome(10);
        System.out.println(palindrome);

    }
    /*1.回文数*/
    public static boolean isPalindrome(int x) {

        /*1.首先转换成字符串*/
        int num = x;
        char[] chars = String.valueOf(x).toCharArray();
        int len = chars.length;

        for (int i = 0; i < len/2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }


        return true;
    }

}
