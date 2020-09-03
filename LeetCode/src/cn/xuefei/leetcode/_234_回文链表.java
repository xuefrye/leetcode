package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/8 19:09
 * Version: 1.0
 * File: _234_回文链表
 * Description:
 */
public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        //先用快慢指针定位到链表中间和尾部
        ListNode midNode = getMidNode(head);
        //然后从中间翻转链表,此时尾部就变成头结点了
        ListNode reversedHead = reverse(midNode.next);
        //然后从两个头部开始对比,是否是回文
        while(reversedHead != null){
            if(reversedHead.val != head.val) return false;

            reversedHead = reversedHead.next;
            head = head.next;
        }
        //最后恢复链表.这题没有说要恢复链表.所以可以不用恢复.
        return true;
    }

    public ListNode getMidNode(ListNode head){
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        //空或者只有一个结点不需要翻转
        if(head == null || head.next == null) return head;

        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
