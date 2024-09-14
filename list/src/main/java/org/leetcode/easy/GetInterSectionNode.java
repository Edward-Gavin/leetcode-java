package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * @author: shiwei10
 * @create: 2024-09-14 23:43
 */
public class GetInterSectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null && headB == null) {
            return null;
        }

        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while (headA != headB) {
            if (headA == null) {
                headA = dummyB;
            } else {
                headA = headA.next;
            }

            if (headB == null) {
                headB = dummyA;
            } else {
                headB = headB.next;
            }

        }
        return headA;
    }
}
