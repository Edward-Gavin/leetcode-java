package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * @author: shiwei10
 * @create: 2024-09-15 10:16
 */
public class HasCycle {
    public static boolean hasCycle(ListNode head) {

        ListNode dummy = new ListNode(-1, head);

        ListNode slow = dummy;
        ListNode fast = dummy;


        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }



        return false;
    }

    public static void main(String[] args) {
        ListNode l9 = new ListNode(9, null);
        ListNode l8 = new ListNode(8, l9);
        ListNode l7 = new ListNode(7, l8);
        ListNode l6 = new ListNode(1, l7);
        ListNode l5 = new ListNode(2, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        l9.next = l5;
        boolean res = hasCycle(l1);
        System.out.println(res);

    }
}
