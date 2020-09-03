package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/28 6:05
 * Version: 1.0
 * File: _21_合并两个有序链表
 * Description:
 */
public class _21_合并两个有序链表 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;

        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                cursor.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                cursor.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cursor = cursor.next;
        }

        while(l1 != null){
            cursor.next = new ListNode(l1.val);
            l1 = l1.next;
            cursor = cursor.next;
        }

        while(l2 != null){
            cursor.next = new ListNode(l2.val);
            l2 = l2.next;
            cursor = cursor.next;
        }

        return dummy.next;
    }
}
