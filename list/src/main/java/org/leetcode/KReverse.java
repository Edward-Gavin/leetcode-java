package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/10 14:36
 */
public class KReverse {
    public static ListNode reverse(ListNode head, int k) {
        // 头插法
        ListNode curNode = head;
        ListNode nextNode = null;
        ListNode temp;

        while (curNode != null) {
             temp = curNode.next;
             curNode.next = nextNode;
             nextNode = curNode;
             curNode = temp;
        }

        return nextNode;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode reverse = reverse(l1, 3);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
