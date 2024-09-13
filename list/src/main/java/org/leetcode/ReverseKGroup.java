package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/10 14:36
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;
        ListNode end = head;
        int count = 0;
        while (end != null) {
            count++;
            if (count % k == 0) {
                start = reverse(start, end);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode cur = start.next;
        ListNode pre = start;
        ListNode first = cur;

        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        start.next = pre;
        first.next = cur;

        return first;
    }

    public static void main(String[] args) {
        ListNode l9 = new ListNode(9, null);
        ListNode l8 = new ListNode(8, l9);
        ListNode l7 = new ListNode(7, l8);
        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode reverse = reverseKGroup(l1, 3);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
