package com.kevin.Code.String;

/**
 * @author Vinlee Xiao
 * @Classname ReplaceSpace
 * @Description 剑指 Offer 05. 替换空格 简单
 * @Date 2021/8/13 18:46
 * @Version 1.0
 */
public class ReplaceSpace {
    public static void main(String[] args) {

    }

    public static String replaceSpace(String s) {
        int len = s.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {

            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }

        }
        return builder.toString();
    }
}
