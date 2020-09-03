package _05_链表._0019;

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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

