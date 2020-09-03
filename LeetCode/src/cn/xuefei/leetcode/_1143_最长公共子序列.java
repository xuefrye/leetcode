package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/14 12:20
 * Version: 1.0
 * File: _1143_最长公共子序列
 * Description:
 */
public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    // dp数组压缩1维
    public int longestCommonSubsequence1(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;

        int[] dp = new int[text2.length()+1];

        for (int i = 1; i <= text1.length(); i++) {
            int last = 0;
            for (int j = 1; j <= text2.length(); j++) {
                int temp = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[j] = 1 + last;
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }

                last = temp;
            }
        }

        return dp[text2.length()];
    }

}
