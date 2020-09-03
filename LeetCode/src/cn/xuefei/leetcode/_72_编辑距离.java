package cn.xuefei.leetcode;

import java.util.Arrays;

/**
 * Author: xuefrye
 * Date: 2020/6/12 17:52
 * Version: 1.0
 * File: _72_编辑距离
 * Description:
 */
public class _72_编辑距离 {
    String s1;
    String s2;
    Integer[][] dpTable;

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        s1 = word1;
        s2 = word2;
        dpTable = new Integer[s1.length() - 1][s2.length() - 1];
        return dp(s1.length() - 1, s2.length() - 1);
    }

    int dp(int i, int j) {
        if (i == -1) {
            return j - i;
        }
        if (j == -1) {
            return i - j;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp(i - 1, j - 1);
        } else {
            return Math.min(Math.min(
                    dp(i - 1, j) + 1,
                    dp(i, j - 1) + 1),
                    dp(i - 1, j - 1) + 1);
        }
    }


    public int minDistance迭代(String word1, String word2) {
        // dp[i][j]是以第i/j结尾的字符串,以1开始,最小的距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];


        //base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Arrays.stream(new int[]{
                            dp[i - 1][j] + 1,
                            dp[i - 1][j - 1] + 1,
                            dp[i][j - 1] + 1
                    }).min().getAsInt();
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        _72_编辑距离 p = new _72_编辑距离();

        int i = p.minDistance迭代("dinitrophenylhydrazine", "benzalphenylhydrazone");
        System.out.println(i);
    }
}
