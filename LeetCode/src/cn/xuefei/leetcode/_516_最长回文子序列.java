package cn.xuefei.leetcode;

import java.util.Arrays;

/**
 * Author: xuefrye
 * Date: 2020/6/14 13:15
 * Version: 1.0
 * File: _516_最长回文子序列
 * Description:
 */
public class _516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;

        int[][] dp = new int[s.length()][s.length()];

//        for (int[] ints : dp) {
//            Arrays.fill(ints, 1);
//        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start + len - 1 <= s.length() - 1; start++) {
                int i = start;
                int j = start + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }

            }
        }

        return dp[0][s.length()-1];
    }
}
