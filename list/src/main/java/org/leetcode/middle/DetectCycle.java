package org.leetcode.middle;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2025/4/2 17:36
 * @Description: 142. 环形链表 II
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                while (slow != cur) {
                    slow = slow.next;
                    cur = cur.next;
                }
                return cur;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        common.next = l1;
        l1.next = l2;

        ListNode head1 = new ListNode(4);
        ListNode n1 = new ListNode(1);
        head1.next = n1;
        n1.next = common;

        l2.next = common;

        ListNode listNode = new DetectCycle().detectCycle(head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
