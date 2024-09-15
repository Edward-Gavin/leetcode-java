package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * @author: shiwei10
 * @create: 2024-09-15 10:26
 */
public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                while (slow != cur) {
                    slow = slow.next;
                    cur = cur.next;
                }
                return cur;
            }
        }
        return null;
    }
}
