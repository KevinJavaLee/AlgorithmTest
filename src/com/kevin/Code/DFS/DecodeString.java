package com.kevin.Code.DFS;

import java.util.Stack;

/**
 * @Project LeetCode
 * @ClassName DecodeString
 * @Description Leetcode 394 字符串解码 深度优先遍历 中等难度 中频 没啥思路
 * @Author Vinlee Xiao
 * @Date 2021/06/20/13:17
 * @Version 1.0
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String s1 = decodeString(s);
        System.out.println(s1);
    }

    /**
     * 思路：
     * 3[a2[c]] 最复杂情形
     * abc3[cd]xyz
     * 2[abc]3[cd]ef
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }

        Stack<Integer> digitStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        //用于存储最终的结果
        StringBuilder res = new StringBuilder();

        int digit = 0;
        //记录下标
        int index = 0;

        while (index < len) {

            char ch = s.charAt(index);
            //如果碰到[,则将数字和字符串入栈
            if (ch == '[') {

                digitStack.add(digit);
                strStack.add(res.toString());
                //将数字和字符串重新置为0
                digit = 0;
                res.setLength(0);

            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                String popStr = strStack.pop();
                Integer popDigit = digitStack.pop();

                for (int i = 0; i < popDigit; i++) {
                    tmp.append(res);
                }
                res.setLength(0);
                res.append(popStr+tmp.toString());


            } else if (ch >= '0' && ch <= '9') {
                digit = digit * 10 + Integer.parseInt(ch + "");

            } else {
                res.append(ch);

            }
            index++;
        }

        return res.toString();

    }



}
