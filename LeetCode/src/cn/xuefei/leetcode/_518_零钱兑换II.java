package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/12 17:14
 * Version: 1.0
 * File: _518_零钱兑换II
 * Description:
 */
public class _518_零钱兑换II {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < dp[0].length; i++) {
            //如果只用第一个硬币能凑够i的数量,那么方法数量就为1.
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + (j - coins[i] < 0 ? 0 : dp[i][j - coins[i]]);
            }
        }

        return dp[coins.length - 1][amount];
    }
}
