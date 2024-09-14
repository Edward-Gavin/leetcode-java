package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/14 13:05
 */
public class DeleteMiddleNode {
    public static ListNode deleteMiddle(ListNode head) {

        // 有一个节点的话，认为这个节点就是中间节点
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        //  找到中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 删除
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode reverse = deleteMiddle(l1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
