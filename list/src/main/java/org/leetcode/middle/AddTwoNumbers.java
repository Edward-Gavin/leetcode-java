package org.leetcode.middle;

import org.leetcode.ListNode;

/**
 * @Author: shiwei10
 * @Date: 2024/9/14 09:54
 * @Description: 2. 两数相加
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int flag = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;

            sum = value1 + value2 + flag;

            flag = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(flag == 1){
            cur.next = new ListNode(flag);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode la = new ListNode(9, null);
        ListNode lb = new ListNode(8, la);
        ListNode lc = new ListNode(7, lb);
        ListNode ld = new ListNode(6, lc);

//
//        ListNode l9 = new ListNode(9, null);
//        ListNode l8 = new ListNode(8, l9);
//        ListNode l7 = new ListNode(7, l8);
//        ListNode l6 = new ListNode(6, l7);
//        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode reverse = addTwoNumbers(l1, ld);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
