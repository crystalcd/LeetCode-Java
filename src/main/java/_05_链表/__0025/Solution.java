package _05_链表.__0025;

import data.struct.linked.ListNode;

public class Solution {

    /**
     * 25. K 个一组翻转链表
     *
     * 先反转以 head 开头的 k 个元素。
     * 将k+1的元素作为head 递归调用reverseKGroup
     * 再将上述过程的结果连接起来
     *
     * base case
     *          不足k 不反转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        ListNode a=head,b=head;
        for(int i=0;i<k;i++) {
            if(b==null){
                return head;
            }
            b=b.next;
        }
        ListNode newHead = reverse1(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    /**
     * 反转整个链表，返回链表头节点
     * 反转方式1 每次将当前节点的后一个节点插入到虚拟头节点后
     * @param head
     * @return
     */
    public ListNode reverse1(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

    /**
     * 反转head到end的链表
     * @param head
     * @param end
     * @return
     */
    public ListNode reverse1(ListNode head,ListNode end){
        if(head==null) {
            return null;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=end) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

    /**
     * 反转整个链表，返回链表头节点
     * 反转方式2 用next保存当前节点cur的后一个节点 将当前节点cur断开指向前一个节点pre，然后更新pre执行cur，cur指向next
     * @param head
     * @return
     */
    public ListNode reverse2(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pre = null,cur=head,next=head;
        while(cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转链表head到end
     * @param head
     * @param end
     * @return
     */
    public ListNode reverse2(ListNode head,ListNode end) {
        if(head==null) {
            return null;
        }
        ListNode pre = null,cur=head,next=head;
        while(cur!=end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
