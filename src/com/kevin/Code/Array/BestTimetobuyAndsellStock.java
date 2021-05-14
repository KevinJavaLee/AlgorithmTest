package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName BestTimetobuyAndsellStock
 * @Description Leetcode121. 买卖股票的最佳时机 简单 高频  看题解有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/13/10:10
 * @Version 1.0
 */
public class BestTimetobuyAndsellStock {
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        int i = maxProfit(nums);
        System.out.println(i);
    }

    /**
     * 一次遍历  一个数记录历史最低点
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int len = prices.length;
        int maxValue = 0;
        if (len == 1) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxValue){
                maxValue = prices[i] - minPrice;
            }
        }

        if (maxValue > 0) {
            return maxValue;
        }

        return 0;
    }


    /**
     * 暴力法 不合适
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {

        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        //初始最大利润
        int maxProfit = prices[1] - prices[0];


        for (int i = 0; i < len; i++) {

            for (int j = i+1; j < len; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];

                }

            }
        }

        if (maxProfit > 0) {
            return maxProfit;
        }

        return 0;
    }
}
