package org.leetcode.review;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 16:34
 */
public class Reverse {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }

        return last;
    }
}
