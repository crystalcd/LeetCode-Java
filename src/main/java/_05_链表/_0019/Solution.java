package _05_链表._0019;

import data.struct.linked.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumyHead = new ListNode();
        ListNode q = dumyHead, p = dumyHead;
        p.next = head;
        int dis = 0;
        while (p != null) {
            if (dis == n + 1) {
                q = q.next;
            } else {
                dis++;
            }
            p = p.next;
        }
        q.next = q.next.next;
        return dumyHead.next;
    }
}



