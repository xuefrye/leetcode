package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/10 11:04
 * Version: 1.0
 * File: _53_最大子序和
 * Description:
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(ans < dp[i])
                ans = dp[i];
        }

        return ans;
    }
}
