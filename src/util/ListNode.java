package util;

import java.util.ArrayList;

/**
 * Created by Nano on 2015/9/21.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    /**
     * 没有考虑到有环的链表，导致无限循环
     * @return
     */
    @Override
    public String toString() {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        String str = val + "";
        ListNode node = this.next;
        list.add(this);
        while (node != null && !list.contains(node)) {
            list.add(node);
            str += "->" + node.val;
            node = node.next;
        }
        return str;
    }
}
