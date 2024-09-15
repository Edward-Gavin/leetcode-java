package org.leetcode.easy;

import org.leetcode.ListNode;

import java.util.Stack;

/**
 * @author: shiwei10
 * @create: 2024-09-15 09:20
 */
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {

            return true;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode fast = dummy;
        ListNode slow = dummy;


        // 找中间的位置
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转后边的链表
        ListNode list1 = reverse(slow.next);
        slow.next = null;

        // 前面的链表头
        ListNode list2 = dummy.next;

        // 比较两个链表的值是否相同
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            } else {
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        return true;
    }



    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode last = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        return last;
    }



    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        boolean result = isPalindrome(l1);
    }
}
