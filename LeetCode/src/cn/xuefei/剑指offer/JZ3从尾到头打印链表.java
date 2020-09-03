package cn.xuefei.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: xuefei
 * @date: 2020-09-01
 * @version: 1.0
 * @description: TODO
 */
public class JZ3从尾到头打印链表 {
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if (listNode == null) return new ArrayList<>(0);

            ArrayList<Integer> integers = new ArrayList<>();
            while (listNode != null) {
                integers.add(listNode.val);
                listNode = listNode.next;
            }

            Collections.reverse(integers);
            return integers;
        }
    }
}
