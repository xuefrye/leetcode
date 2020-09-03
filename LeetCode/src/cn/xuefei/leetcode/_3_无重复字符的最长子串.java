package cn.xuefei.leetcode;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: xuefrye
 * Date: 2020/6/15 17:15
 * Version: 1.0
 * File: _3_无重复字符的最长子串
 * Description:
 */
public class _3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring动态规划(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int[] dp = new int[s.length()];

        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = i - 1, count = 0; count < dp[i - 1]; count++, j--) {
                if (s.charAt(j) != c) {
                    dp[i]++;
                } else
                    break;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLongestSubstring滑动窗口(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int l = 0;
        int r = -1;
        Set<Character> window = new HashSet<>();
        int len = 0;
        //r增大直到有重复.
        while (r < s.length() - 1) {
            //当前值c1
            char c1 = s.charAt(++r);
            if (window.contains(c1)) {
                while (true) {//一直循环到找到
                    char c2 = s.charAt(l++);
                    if (c2 != c1) {
                        window.remove(c2);
                    }else{
                        break;
                    }
                }
            } else {
                window.add(c1);
                len = Math.max(len,r-l + 1);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 p = new _3_无重复字符的最长子串();
        System.out.println(p.lengthOfLongestSubstring滑动窗口("abcabcbb"));
        System.out.println(p.lengthOfLongestSubstring滑动窗口("pwwkew"));
        System.out.println(p.lengthOfLongestSubstring滑动窗口("abc"));
        System.out.println(p.lengthOfLongestSubstring滑动窗口("aaa"));
    }
}
