package org.leetcode.middle;

import org.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: shiwei10
 * @create: 2024-09-15 18:09
 */
public class SortedList {
    public ListNode sortList(ListNode head){

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode node = dummy;
        int count = 0;
        int index= 0;

        while (cur != null) {
           count ++;
           cur = cur.next;
        }

        int[] ints = new int[count];
        cur = head;

        while (cur != null) {
            ints[index] = cur.val;
            index ++;
            cur = cur.next;
        }

        Arrays.sort(ints);

        for (int i : ints) {
            node.next = new ListNode(i);
            node = node.next;

        }

        return dummy.next;
    }
}
