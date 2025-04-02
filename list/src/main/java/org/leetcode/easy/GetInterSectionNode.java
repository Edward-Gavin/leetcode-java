package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * @author: shiwei10
 * @create: 2024-09-14 23:43
 * @description: 160. 相交链表
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

        ListNode head2 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(1);
        head2.next = n2;
        n2.next = n3;
        n3.next = common;

        GetInterSectionNode getInterSectionNode = new GetInterSectionNode();
        ListNode intersectionNode = getInterSectionNode.getIntersectionNode(head1, head2);
        while(intersectionNode != null){
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;

        }
    }
}
