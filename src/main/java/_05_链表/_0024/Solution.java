package _05_链表._0024;

import data.struct.linked.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * Medium
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution {
    /**
     * 根据题意转换
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dumpyNode = new ListNode();
        dumpyNode.next = head;
        ListNode p = dumpyNode;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;

            p = node1;
        }
        return dumpyNode.next;
    }
}

