package cn.xuefei.leetcode;

import java.util.*;

/**
 * Author: xuefrye
 * Date: 2020/6/15 0:41
 * Version: 1.0
 * File: _752_打开转盘锁
 * Description:
 */
public class _752_打开转盘锁 {
    public int openLock(String[] deadends, String target) {


        Set<String> deadendSet = new HashSet<>();

        Collections.addAll(deadendSet, deadends);

        if (deadendSet.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();

        queue.add("0000");
        deadendSet.add("0000");

        int times = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return times;

                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(curr, j);
                    if (!deadendSet.contains(plusOne)) {
                        queue.add(plusOne);
                        deadendSet.add(plusOne);
                    }
                }

                for (int j = 0; j < 4; j++) {
                    String minusOne = minusOne(curr, j);
                    if (!deadendSet.contains(minusOne)) {
                        queue.add(minusOne);
                        deadendSet.add(minusOne);
                    }
                }
            }

            times++;
        }
        return -1;
    }

    public String plusOne(String num, int index) {
        char[] chars = num.toCharArray();
        if (chars[index] == '9')
            chars[index] = '0';
        else
            chars[index]++;

        return new String(chars);
    }

    public String minusOne(String num, int index) {
        char[] chars = num.toCharArray();
        if (chars[index] == '0')
            chars[index] = '9';
        else
            chars[index]--;

        return new String(chars);
    }
}
