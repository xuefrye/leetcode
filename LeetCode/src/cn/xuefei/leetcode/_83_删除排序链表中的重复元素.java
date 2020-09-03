package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/28 9:25
 * Version: 1.0
 * File: _83_删除排序链表中的重复元素
 * Description:
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode curr = head;

        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
