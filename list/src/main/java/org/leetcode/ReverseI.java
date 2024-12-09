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


    public static ListNode reverseV1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

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


    public static void main(String[] args) {
//        ListNode l9 = new ListNode(9, null);
//        ListNode l8 = new ListNode(8, l9);
//        ListNode l7 = new ListNode(7, l8);
//        ListNode l6 = new ListNode(6, l7);
//        ListNode l5 = new ListNode(5, l6);
//        ListNode l4 = new ListNode(4, l5);
//        ListNode l3 = new ListNode(3, l4);
//        ListNode l2 = new ListNode(2, l3);
//        ListNode l1 = new ListNode(1, l2);
//
//
//        ReverseI reverseI = new ReverseI();
//        ListNode listNode = ReverseI.reverseV1(l1);
//
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        System.out.println(5 / 2);
        System.out.println(5 % 2);
    }

    public ListNode reverseV3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

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
