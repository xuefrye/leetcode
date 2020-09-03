package cn.xuefei.leetcode;

import java.security.cert.TrustAnchor;
import java.util.concurrent.ForkJoinPool;

/**
 * Author: xuefrye
 * Date: 2020/6/9 18:43
 * Version: 1.0
 * File: _5_最长回文子串
 * Description:
 */
public class _5_最长回文子串 {
    boolean dp[][];

    public String longestPalindrome(String s) {
        if(s==null || s.length() == 0) return "";
        dp = new boolean[s.length()][s.length()];
        int ansi = 0;
        int ansj = 0;
        int maxLen = 0;

        //从长度1开始遍历
        for (int len = 1; len <= s.length(); len++) {
            //起点从0开始,重点不要超过s.length
            for (int start = 0; start + len - 1 < s.length(); start++) {
                int i = start;
                int j = start + len - 1;

                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j] && maxLen < len){
                    maxLen = len;
                    ansi = i;
                    ansj = j;
                }
            }
        }
        return s.substring(ansi,ansj+1);
    }

    public static void main(String[] args) {

    }
}
