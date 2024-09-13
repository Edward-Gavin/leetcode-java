package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/13 14:25
 */
public class DeleteDuplicateNum {
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            int value = cur.next.val;
            if (value == cur.next.next.val) {

                // 一直删，直到删完
                while (cur.next != null && cur.next.val == value) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode reverse = deleteDuplicates(l1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
