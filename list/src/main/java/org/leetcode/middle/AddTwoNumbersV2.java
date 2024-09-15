package org.leetcode.middle;

import org.leetcode.ListNode;

/**
 * @author: shiwei10
 * @create: 2024-09-15 17:34
 */
public class AddTwoNumbersV2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int flag = 0;

        while (l1 != null || l2 != null) {

            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;

            int sum = value1 + value2 + flag;

            int value = sum / 10;
            flag = sum % 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }


            cur.next = new ListNode(value);
            cur = cur.next;
        }

        if (flag != 0) {
            cur.next = new ListNode(flag);
        }
        return dummy.next;

    }
}
