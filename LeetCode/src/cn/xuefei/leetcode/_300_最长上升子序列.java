package cn.xuefei.leetcode;

import java.util.Arrays;

/**
 * Author: xuefrye
 * Date: 2020/6/11 10:36
 * Version: 1.0
 * File: _300_最长上升子序列
 * Description:
 */
public class _300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int[] dp = new int[nums.length];

        //base case
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            //求以i结尾的最大值,初始化为最小值.
            int maxLen = 0;

            for (int j = 0; j < i; j++) {
                //如果之前的数小,而且dp[j]最大
                if(nums[j] < nums[i] && maxLen < dp[j]){
                    maxLen = dp[j];
                }
            }

            dp[i] = maxLen + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
