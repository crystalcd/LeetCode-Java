package _05_链表._0092;

import data.struct.linked.ListNode;

public class Solution {
    ListNode successor = null; // 记录后继节点
    /**
     * 92. 反转链表 II
     *  迭代
     *  先找到需要转换的节点cur前的一个节点为pre, 当前cur的下一个节点为tmp，让cur的next指向tmp的next，
     *  tmp的next指向pre的next，pre的next执行tmp。
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 当head=left时 将head.next放到head前直到 head=right后
        if(head==null) {
            return head;
        }
        ListNode predecessor = new ListNode(-1,head);// 前驱
        ListNode dummy = predecessor; // 虚拟节点 用来记录最后返回的头节点
        int count=0;
        while(count<left-1) {
            ++count;
            predecessor = predecessor.next;
        }
        ListNode cur = predecessor.next;
        while(count<right-1) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = predecessor.next;
            predecessor.next = tmp;
            System.out.println(cur.val+" "+tmp.val+"  "+predecessor.val);
            ++count;
        }
        return dummy.next;
    }

    /**
     * 递归
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if(left==1) {
            return reverseBetween1(head,right);
        }
        head.next = reverseBetween1(head.next,left-1,right-1);
        return head;
    }

    /**
     * 递归反转整个链表
     * @param head
     * @return
     */
    public ListNode reverseBetween1(ListNode head) {
        if(head.next==null) { // 只有头节点 返回头
            return head;
        }
        // head.next为起点 反转前所有节点 返回反转之后的头节点
        ListNode last = reverseBetween1(head.next);
        head.next.next=head;
        head.next = null;
        return last;
    }
    /**
     * 递归反转链表的前n个几点
     * @param head
     * @return
     */
    public ListNode reverseBetween1(ListNode head,int n) {
        if(n==1) {
            successor = head.next;
            return head;
        }
        // head.next为起点 反转前n-1个节点 返回反转之后的头节点
        ListNode last = reverseBetween1(head.next,n-1);
        head.next.next=head;
        head.next =successor;
        return last;
    }
}





