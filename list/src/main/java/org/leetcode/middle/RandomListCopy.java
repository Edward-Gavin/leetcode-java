package org.leetcode.middle;

import java.util.HashMap;

/**
 * @author: shiwei10
 * @create: 2024-09-15 19:39
 */
public class RandomListCopy {

    class Node{

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public Node copyRandomList(Node head){

        Node cur = head;

        HashMap<Node, Node> map = new HashMap<Node, Node>();

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

}
