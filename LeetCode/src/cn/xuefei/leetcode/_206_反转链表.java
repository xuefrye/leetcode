package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/27 7:54
 * Version: 1.0
 * File: _206_反转链表
 * Description:
 */
public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode now = head.next;

        do {
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }while (now != null);

        head.next = null;
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
