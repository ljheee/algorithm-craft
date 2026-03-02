package com.ljheee.algorithm.dp;

/**
 * 背包问题
 */
public class BackPack {


    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param weights 表示商品重量数组
     * @param values 表示商品价值数组
     */
    public static int[][] backPack(int m, int n, int[] weights, int[] values) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (weights[i - 1] <= j) {  //如果能装物品i
                    dp[i][j] = Math.max(
                            values[i - 1] + dp[i - 1][j - weights[i - 1]],// 装物品i 时，最大价值
                            dp[i - 1][j]  //不装 物品i，取之前的最大值
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }





}
