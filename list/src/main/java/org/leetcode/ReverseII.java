package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/11 17:19
 */
public class ReverseII {
    public static ListNode reverse(ListNode head, int left, int right) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode cur = result;

        int i = 1;

        while (i < left) {
            cur = cur.next;
            i++;
        }

        ListNode start = cur;
        ListNode first = cur.next;
        ListNode pre = cur;
        cur = cur.next;

        while (i >= left && i <= right) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            i++;
        }

        start.next = pre;
        first.next = cur;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode reverse = reverse(l1, 2, 4);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
