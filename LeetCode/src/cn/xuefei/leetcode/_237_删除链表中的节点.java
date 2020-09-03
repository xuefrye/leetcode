package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/27 7:35
 * Version: 1.0
 * File: _237删除链表中的节点
 * Description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next =node.next.next;
    }
}
