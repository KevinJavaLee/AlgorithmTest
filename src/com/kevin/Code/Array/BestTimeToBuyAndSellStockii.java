package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName BestTimeToBuyAndSellStockii
 * @Description Leetcode 122.  简单 买卖股票的最佳时机 II 简单贪心算法 有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/30/17:34
 * @Version 1.0
 */
public class BestTimeToBuyAndSellStockii {
    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        int i = maxProfit(nums);
        System.out.println(i);
    }


    /**
     * 输入: prices = [7,1,5,3,6,4]
     * 1 2 3 4 5
     * 输出: 7
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int left = 0, right = 1;
        int sum = 0;

        while (right<len) {

            if (prices[left] < prices[right]) {

                sum += (prices[right]-prices[left]);

            }
            left++;
            right++;
        }

        return sum;
    }
}

