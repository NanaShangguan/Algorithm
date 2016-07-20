package util;

/**
 * Created by Nano on 2015/10/20.
 */
public class LinkedListFactory {
    public static ListNode getListFromIntArray(int[] arr) {
        ListNode head = null, last = null;
        for (int each : arr) {
            if (head == null) {
                head = new ListNode(each);
                last = head;
            } else {
                last.next = new ListNode(each);
                last = last.next;
            }
        }
        return head;
    }
}
