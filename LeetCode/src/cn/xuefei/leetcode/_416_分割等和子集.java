package cn.xuefei.leetcode;

import java.util.Arrays;

/**
 * Author: xuefrye
 * Date: 2020/6/12 11:38
 * Version: 1.0
 * File: _416_分割等和子集
 * Description:
 */
public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // 选到第j个物品时,数组的和能否为target
        boolean[][] dp = new boolean[nums.length][target + 1];

        //base case
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j - nums[i] < 0) continue;

                if (j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }

        return dp[nums.length - 1][target];
    }

    public boolean canPartition一维(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // 选到第j个物品时,数组的和能否为target
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if(j == nums[i]) dp[j] = true;
                else if(j-nums[i] < 0) continue;
                else dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        _416_分割等和子集 p = new _416_分割等和子集();

        int[] arr = new int[]{1, 5, 11, 5};
        boolean b = p.canPartition(arr);
        System.out.println(b);
    }
}
