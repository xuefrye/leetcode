package cn.xuefei.leetcode;

import java.util.Arrays;

/**
 * Author: xuefrye
 * Date: 2020/6/10 17:35
 * Version: 1.0
 * File: _322_零钱兑换
 * Description:
 */
public class _322_零钱兑换 {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];

        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                //不符合情况
                if (i - coin < 0) continue;

                if(dp[i-coin] != -1)//如果dp[i-coin]有解
                    dp[i] = Math.min(dp[i - coin] + 1,dp[i]);
            }
        }

        return dp[amount]== amount+1 ? -1: dp[amount];
    }

    public static void main(String[] args) {
        _322_零钱兑换 p = new _322_零钱兑换();
        int[] arr = new int[]{2,5,10,1};
        int i = p.coinChange(arr, 27);
        System.out.println(i);
    }
}
