package org.leetcode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/11 17:21
 */
public class ReverseI {
    public static ListNode reverse(ListNode head) {
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
}
