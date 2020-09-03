package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/8 16:18
 * Version: 1.0
 * File: _160_相交链表
 * Description:
 */
public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        while (a != null) {
            lenA++;
            a = a.next;
        }

        if (lenA == 0) return null;

        ListNode b = headB;
        while (b != null) {
            lenB++;
            b = b.next;
        }

        if (lenB == 0) return null;

        if (lenA == lenB) {
            while (headA != null || headB != null) {
                if (headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        } else if (lenA > lenB) {
            int delta = lenA - lenB;
            while (delta > 0) {
                headA = headA.next;
                delta--;
            }

            while (headA != null || headB != null) {
                if (headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        } else {
            int delta = lenB - lenA;
            while (delta > 0) {
                headB = headB.next;
                delta--;
            }
            while (headA != null || headB != null) {
                if (headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }

}
