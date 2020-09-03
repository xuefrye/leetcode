package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/8 17:01
 * Version: 1.0
 * File: _86_分隔链表
 * Description:
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(0);
        ListNode less = dummyLess;
        ListNode dummyMoreEqual = new ListNode(0);
        ListNode moreEqual = dummyMoreEqual;


        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                moreEqual.next = head;
                moreEqual = moreEqual.next;
            }
            head = head.next;
        }
        moreEqual.next = null;
        less.next = dummyMoreEqual.next;

        return dummyLess.next;
    }
}
