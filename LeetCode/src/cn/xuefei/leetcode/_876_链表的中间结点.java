package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/28 9:33
 * Version: 1.0
 * File: _876_链表的中间结点
 * Description:
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(-1);

        dummy.next  = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.next;
    }
}
