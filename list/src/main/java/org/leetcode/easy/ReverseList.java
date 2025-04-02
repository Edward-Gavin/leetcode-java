package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2025/4/2 17:11
 * @Description: 206. 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode last = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        common.next = l1;
        l1.next = l2;

        ListNode head1 = new ListNode(4);
        ListNode n1 = new ListNode(1);
        head1.next = n1;
        n1.next = common;

        ListNode listNode = new ReverseList().reverseList(head1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }
}
