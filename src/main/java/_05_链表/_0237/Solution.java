package _05_链表._0237;

import data.struct.linked.ListNode;

public class Solution {
    ListNode head;

    Solution(ListNode head) {
        this.head = head;
    }

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

