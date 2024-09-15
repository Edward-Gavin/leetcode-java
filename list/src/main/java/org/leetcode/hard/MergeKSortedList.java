package org.leetcode.hard;

import org.leetcode.ListNode;

/**
 * @author: shiwei10
 * @create: 2024-09-15 19:00
 */
public class MergeKSortedList {
    public ListNode mergeList(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }

        if (l2 == null) {
            cur.next = l1;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;

        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }

        ListNode help = null;

        for (ListNode list : lists) {
            help = mergeList(help, list);
        }

        return help;
    }
}
