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
}
