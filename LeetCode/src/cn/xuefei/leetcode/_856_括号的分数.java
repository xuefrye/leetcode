package cn.xuefei.leetcode;

import java.util.Stack;

/**
 * Author: xuefrye
 * Date: 2020/5/28 21:41
 * Version: 1.0
 * File: _856_括号的分数
 * Description:
 */
public class _856_括号的分数 {
    public int scoreOfParentheses(String S) {
        int deep = 0;
        int sum = 0;

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(' && S.charAt(i+1) == ')'){
                sum += Math.pow(2,deep);
                i++;
            }else if(S.charAt(i) == '(') {
                deep++;
            }else if(S.charAt(i) == ')'){
                deep--;
            }
        }

        return sum;
    }
}
