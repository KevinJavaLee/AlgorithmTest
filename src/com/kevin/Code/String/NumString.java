package com.kevin.Code.String;

/**
 * @author Vinlee Xiao
 * @Classname NumString
 * @Description 剑指 Offer 20. 表示数值的字符串 中等难度
 * @Date 2021/8/19 15:32
 * @Version 1.0
 */
public class NumString {
    public static void main(String[] args) {

        boolean number = isInteger("2");
        boolean b = isNumeric("1a3.1  3");
        boolean e = isE("-1E+15.4");
//        System.out.println(number);
        System.out.println(e);
    }

    /**
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        return false;
    }


    /**
     * @return
     */
    public static boolean isInteger(String s) {

        //去除空格
        String s1 = s.trim();
        int size = s1.length();
        if (size == 0) {
            return false;
        }
        int start = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            start = 1;
        }

        while (start < size) {
            if (s.charAt(start) > '9' || s.charAt(start) < '0') {

                return false;
            }
            start++;
        }

        return true;
    }


    /**
     * 判断是否为小数
     *
     * @return
     */
    public static boolean isNumeric(String s) {
        String s1 = s.trim();

        int size = s1.length();

        if (size == 0) {
            return false;
        }
        int startIndex = 0;
        if (s1.charAt(0) == '-' || s1.charAt(0) == '+') {
            startIndex = 1;
        }
        //之前的字符串是否碰到过。
        boolean isFlag = false;
        int start = startIndex;
        while (start < size) {
//            System.out.println(start);
            if (s1.charAt(start) == '.') {
                if (isFlag) {
                    return false;
                }
                if (size - startIndex == 1) {
                    return false;
                }

                isFlag = true;
            } else if ((s1.charAt(start) > '9' || s1.charAt(start) < '0')) {
                if (s1.charAt(start) != '.') {
                    return false;
                }
//
            }
            start++;
        }

        if (!isFlag) {
            return false;
        }

        return true;
    }

    /**
     * @param s
     */
    public static boolean isE(String s) {

        String s1 = s.trim();

        //去掉空格
        int size = s1.length();
        if (size == 0) {
            return false;
        }

        int startIndex = 0;
        if (s1.charAt(0) == '-' || s1.charAt(0) == '+') {
            startIndex = 1;
        }

        int start = startIndex;

        while (start < size) {
            if (s.charAt(start) > '9' || s.charAt(start) < '0') {

                if (s.charAt(start) == 'e' || s.charAt(start) == 'E') {

                    boolean number = isInteger(s1.substring(start + 1, size));
//                    System.out.println(s1.substring(start+1, size));
//                    System.out.println(number);
                    return number;
                }
                return false;
            }
            start++;
        }


        return true;
    }
}
