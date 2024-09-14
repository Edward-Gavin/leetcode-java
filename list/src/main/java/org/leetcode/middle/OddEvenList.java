package org.leetcode.middle;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/14 13:46
 */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy.next;
        ListNode fast = dummy.next.next;

        while (fast.next != null && fast.next.next != null) {

            ListNode temp = slow.next;
            ListNode temp2 = fast.next.next;
            slow.next = fast.next;
            fast.next.next = temp;
            fast.next = temp2;

            slow = slow.next;
            fast = fast.next;
        }

        return dummy.next;
    }

    public static ListNode oddEvenListV2(ListNode head){
        ListNode dummy = new ListNode(-1, head);

        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next != null && fast.next.next != null) {
            oddList.next = slow;
            evenList.next = fast;

            slow = slow.next.next;
            fast = fast.next.next;
        }

        oddList.next = evenList;

        return oddList.next;
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
        ListNode reverse = oddEvenListV2(l1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
