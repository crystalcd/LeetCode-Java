package _05_链表._0092;

import data.struct.linked.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // 构造虚拟节点存储初始头节点
        while(head!=null) {
            head = head.next;
        }
        return dummy.next;
    }
}





