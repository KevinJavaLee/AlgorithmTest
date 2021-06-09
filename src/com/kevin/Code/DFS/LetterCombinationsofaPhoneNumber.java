package com.kevin.Code.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName LetterCombinationsofaPhoneNumber
 * @Description Leetcode 17 电话号码的字母组合 中等难度 有思路
 * @Author Vinlee Xiao
 * @Date 2021/06/09/16:48
 * @Version 1.0
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * 深度优先遍历
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        StringBuffer combine = new StringBuffer();

        if (digits.length() == 0) {
            return result;
        }

        dfs(result, combine, digits, 0);
        return result;
    }

    public static void dfs(List<String> result, StringBuffer combine, String digits, int index) {

        if (index == digits.length()) {
            String s = combine.toString();
            result.add(s);
            return;
        }


        String s = returnPhone(digits.charAt(index));
        for (char i = 0; i < s.length(); i++) {
            combine.append(s.charAt(i));
            dfs(result, combine, digits, index + 1);
            combine.deleteCharAt(combine.length() - 1);
        }
    }

    public static String returnPhone(Character ch) {
        String c;
        switch (ch) {
            case '2':
                c = "abc";
                break;
            case '3':
                c = "def";
                break;
            case '4':
                c = "ghi";
                break;
            case '5':
                c = "jkl";
                break;
            case '6':
                c = "mno";
                break;
            case '7':
                c = "pqrs";
                break;
            case '8':
                c = "tuv";
                break;
            case '9':
                c = "wxyz";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ch);
        }
        return c;
    }
}
