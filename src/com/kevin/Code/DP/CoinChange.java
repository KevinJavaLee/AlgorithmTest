package com.kevin.Code.DP;

import java.util.Arrays;

/**
 * @author Vinlee Xiao
 * @Classname CoinChange
 * @Description Leetcode 322. 零钱兑换 动态规划 中等难度  没啥思路 一看动态就没感觉
 * @Date 2021/9/22 16:50
 * @Version 1.0
 */
public class CoinChange {
    public static void main(String[] args) {

    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        //将动态数组的初始值置为amount+1 因为 amount最多有amount+1种可能
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;


        for (int i = 1; i <= amount; i++) {

            //遍历金币
            for (int j = 0; j < coins.length; j++) {

                //状态转移方程
                //加一个判断条件
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }


            }

        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
