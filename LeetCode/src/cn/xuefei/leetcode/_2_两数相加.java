package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/28 3:39
 * Version: 1.0
 * File: _2_两数相加
 * Description:
 */
public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode now = dummy;

        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + carry;
            now.next = new ListNode(x % 10);
            now = now.next;
            carry = x / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int x = l1.val + carry;
            now.next = new ListNode(x % 10);
            now = now.next;
            carry = x / 10;

            l1 = l1.next;
        }

        while (l2 != null) {
            int x = l2.val + carry;
            now.next = new ListNode(x % 10);
            now = now.next;
            carry = x / 10;

            l2 = l2.next;
        }

        if (carry != 0)
            now.next = new ListNode(1);

        return dummy.next;
    }
}
