package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/28 9:14
 * Version: 1.0
 * File: _203_移除链表元素
 * Description:
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;
        ListNode curr = head;
        ListNode pre = dummyHead;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }

        return dummyHead.next;
    }
}
