package org.leetcode.review;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/19 16:38
 */
public class KGroupReverse {

    public ListNode kReverse(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;
        ListNode end = dummy;

        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode pre = start.next;
            ListNode post = end.next;
            end.next = null;

            start.next = reverse(pre);
            pre.next = post;

            start = pre;
            end = start;
        }

        return dummy.next;
    }


    public static ListNode reverse(ListNode head) {

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
