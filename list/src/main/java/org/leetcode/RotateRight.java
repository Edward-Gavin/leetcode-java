package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/13 17:11
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 1;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1, head);

        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        cur.next = head;
        int position = count - k % count;

        while (position > 0) {
            cur = cur.next;
            position --;
        }

        dummy.next = cur.next;
        cur.next  = null;

        return dummy.next;
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
        ListNode reverse = rotateRight(l1, 5);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
