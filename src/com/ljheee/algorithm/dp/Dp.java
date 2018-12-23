package com.ljheee.algorithm.dp;

/**
 * Created by lijianhua04 on 2018/12/23.
 */
public class Dp {


    public static void main(String[] args) {


        int values[] = {6, 10, 12};//n个物品 各自的价值
        int weights[] = {1, 2, 3};//n个物品 各自的消耗重量
        int n = values.length;//物品数量

        int m = 5;//背包的重量限制
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            values[i - 1] + dp[i - 1][j - weights[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][m]);

    }





}
