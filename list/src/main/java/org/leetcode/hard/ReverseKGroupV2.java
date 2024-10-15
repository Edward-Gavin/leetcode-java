package org.leetcode.hard;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/14 19:37
 * @Description: 25. K 个一组翻转链表
 */
public class ReverseKGroupV2 {
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 计数
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            // 不够k，直接返回
            if (end == null) {
                break;
            }

            // 保存现场
            ListNode pre = start.next;
            ListNode post = end.next;
            // 截取链表
            end.next = null;

            // 局部翻转
            start.next = reverse(pre);
            pre.next = post;
            start = pre;
            end = start;

        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode last = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        return last;
    }
}
