package com.kevin.Code.String;

/**
 * @author Vinlee Xiao
 * @Classname TranslateStr
 * @Description 剑指 Offer 46. 把数字翻译成字符串 中等难度  完全没有思路  看题解才有思路
 * @Date 2021/8/23 10:34
 * @Version 1.0
 */
public class TranslateNum {
    public static void main(String[] args) {
        int i = translateNum(12258);
        System.out.println(i);
    }

    /**
     * @param num
     * @return
     */
    public static int translateNum(int num) {

        String s = String.valueOf(num);
        int len = s.length();

        if (len < 2) {
            return len;
        }
        //定义动态数组
        int[] dp = new int[len + 1];

        //初始化
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {

            dp[i + 1] = dp[i];

            if (s.substring(i - 1, i + 1).compareTo("25") <= 0 && s.substring(i - 1, i + 1).compareTo("10") >= 0) {
                dp[i + 1] = dp[i] + dp[i - 1];
            }

        }


        return dp[len];
    }
}
