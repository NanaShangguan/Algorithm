package lintcode;

import util.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by t-nashan on 9/5/2016.
 */
public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        if (queue.isEmpty()) return null;
        ListNode head = queue.peek();
        ListNode tail = queue.poll();
        if (tail.next != null) queue.add(tail.next);
        tail.next = null;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            if (min.next != null) queue.add(min.next);
            tail.next = min;
            tail = min;
            tail.next = null;
        }
        return head;
    }
}
