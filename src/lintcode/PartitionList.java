package lintcode;

import util.ListNode;

/**
 * Created by t-nashan on 8/25/2016.
 */
public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = null, h1Node = null; //greater
        ListNode h2 = null, h2Node = null; //less than x
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (node.val >= x) {
                if (h1 == null) h1 = node;
                else h1Node.next = node;
                h1Node = node;
            } else {
                if (h2 == null) h2 = node;
                else h2Node.next = node;
                h2Node = node;
            }
            node = next;
        }
        if (h2 == null) return h1;
        h2Node.next = h1;
        return h2;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        System.out.println(new PartitionList().partition(node, 3));
    }
}
