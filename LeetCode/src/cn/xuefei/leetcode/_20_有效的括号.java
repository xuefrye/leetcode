package cn.xuefei.leetcode;

import java.util.Stack;

/**
 * Author: xuefrye
 * Date: 2020/5/28 20:04
 * Version: 1.0
 * File: _20_有效的括号
 * Description:
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.size() == 0)
                    return false;
                Character pop = stack.pop();

                if ((pop == '(' && c != ')') || (pop == '[' && c != ']') || (pop == '{' && c != '}')
                )
                    return false;
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        _20_有效的括号 solution = new _20_有效的括号();
        System.out.println(solution.isValid("(]"));
    }
}
