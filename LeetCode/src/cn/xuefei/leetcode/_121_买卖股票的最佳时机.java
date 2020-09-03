package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/9 18:31
 * Version: 1.0
 * File: _121_买卖股票的最佳时机
 * Description:
 */
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min) min = prices[i];

            maxProfit = Math.max(prices[i] - min, maxProfit);
        }

        return maxProfit;
    }

}
