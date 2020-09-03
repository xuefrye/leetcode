package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/29 5:24
 * Version: 1.0
 * File: _198_打家劫舍
 * Description:
 */
public class _198_打家劫舍 {

    public int rob(int[] nums) {
        java.util.Comparator comparator;

        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i =2 ;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }

        return dp[nums.length];
    }

//    public int rob(int[] nums, int start) {
//        if (start >= nums.length) return 0;
//
//        return Math.max(nums[start] + rob(nums, start + 2), rob(nums, start + 1));
//    }
}
