package cn.xuefei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: xuefrye
 * Date: 2020/6/15 16:20
 * Version: 1.0
 * File: _76_最小覆盖子串
 * Description:
 */
public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        //目标字符串中各个字母的count
        Map<Character, Integer> target = new HashMap<>();
        //窗口内中各个字母的count
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            putAndAddOne(target, t.charAt(i));
        }

        int l = 0;
        int r = -1;

        //有多少种字母已经符合要求
        int valid = 0;
        //记录答案的最短长度,起始点
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (r < s.length()-1 && valid < target.size()) {
            //拿走下个字符
            char c1 = s.charAt(++r);
            if (target.containsKey(c1)) { //如果目标中有此字符
                putAndAddOne(window, c1);  //更新窗口内字符

                //加完后等于说明满足了条件
                if (target.get(c1).equals(window.get(c1))) {
                    valid++;
                }
            }

            while (l <= r && valid == target.size()) {
                //更新答案
                if (len > r - l + 1) {
                    len = r - l + 1;
                    start = l;
                }
                char c2 = s.charAt(l++);
                if (target.containsKey(c2)) {
                    // 如果减之前相等,说明valid--
                    if (target.get(c2).equals(window.get(c2))) {
                        valid--;
                    }
                    putAndMinusOne(window, c2);
                }
            }
        }

        if(len == Integer.MAX_VALUE) return "";
        return s.substring(start,start+len);
    }

    //记录出现次数.
    public void putAndAddOne(Map<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public void putAndMinusOne(Map<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) - 1);
        } else {
            map.put(key, -1);
        }
    }

    public static void main(String[] args) {
        _76_最小覆盖子串 p = new _76_最小覆盖子串();
        System.out.println(p.minWindow("", "A"));
    }
}
