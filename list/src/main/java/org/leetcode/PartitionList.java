package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/13 19:27
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null ) {
            if (fast.next.val < x) {
                ListNode temp1 = fast.next;
                fast.next = fast.next.next;
                temp1.next = slow.next;
                slow.next = temp1;
                slow = slow.next;
                if (fast.next == slow) fast = fast.next;
            } else {
                fast = fast.next;
            }
        }

        return dummy.next;
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
        ListNode reverse = partition(l1, 3);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
