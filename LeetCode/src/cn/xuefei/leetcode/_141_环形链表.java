package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/27 9:11
 * Version: 1.0
 * File: _141_环形链表
 * Description:
 */
public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;


        while(fast != slow){
            if(fast == null || fast.next == null)
                return false;
            else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        return true;
    }
}
