package com.kevin.Code.DP;

/**
 * @author Vinlee Xiao
 * @Classname DiceProbability
 * @Description 剑指 Offer 60. n个骰子的点数 中等难度 动态规划
 * @Date 2021/9/14 16:02
 * @Version 1.0
 */
public class DiceProbability {
    public static void main(String[] args) {
        double[] res = dicesProbability(11);
        for (double re : res) {
            System.out.println(re + " ");
        }
    }


    /**
     * 动态规划
     * 常规思路解决问题 超过时间的限制
     *
     * @param n
     * @return
     */
    public static double[] dicesProbability(int n) {

        final int face = 6;
        final int pointNum = 6 * n;
        int[][] dp = new int[n + 1][pointNum + 1];


        //当骰子为1，置出1的次数
        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }

        //骰子的个数
        for (int i = 2; i <= n; i++) {

            //骰子的和
            for (int j = i; j <= pointNum; j++) {

                //当当前骰子取k时
                for (int k = 1; k <= 6 && k <= j; k++) {

                    //动态规划状态转移公式
                    //
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k];
                }
            }
        }


        //总的次数和
        int total = (int) Math.pow(6, n);

        double[] res = new double[5 * n + 1];
        for (int i = n; i <= pointNum; i++) {
//            System.out.println(dp[n][i]);
            res[i - n] = dp[n][i] * 1.0 / total * 1.0;
//            System.out.println(res[i-n]);
        }

        return res;
    }
}
