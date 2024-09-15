package org.leetcode.hard;

import org.leetcode.ListNode;

import java.util.PriorityQueue;

/**
 * @author: shiwei10
 * @create: 2024-09-15 19:22
 */
public class MergeKSortedListV2 {

    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;

        if (length == 0) {
            return null;
        }

        if (length == 1) {
            return lists[0];
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>();

        for (ListNode list : lists) {
            while (list != null) {
                integers.add(list.val);
                list= list.next;
            }
        }

        while (!integers.isEmpty()){
            cur.next = new ListNode(integers.poll());
            cur = cur.next;
        }

        return dummy.next;

    }
}
