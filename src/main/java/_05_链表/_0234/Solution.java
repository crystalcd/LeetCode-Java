package _05_链表._0234;

import data.struct.linked.ListNode;

import java.util.Stack;

public class Solution {


    /**
     * 234. 回文链表
     * 1. 将原链表翻转成一个新链表，遍历比较两个链表是否一样 时间复杂度O(N) 空间复杂度O(N)
     * 2. 利用链表后序遍历特性。时间复杂度O(N) 空间复杂度O(N)
     * 3. 优化空间复杂度 快慢指针， 快指针每次前进两格 满指针每次前进一格
     *                  奇数 fast没指向null slow需要再前进一格
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode left = head; // 左侧指针
        return postorder(head,left);
    }

    public boolean postorder(ListNode right,ListNode left) {
        if(right==null) {
            return true;
        }
        boolean res = postorder(right.next,left.next);
        res = res&&(right.val==left.val);
        return res;
    }

    /**
     * 优化空间复杂度 空间复杂度O(N)
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null) { // 奇数情况 slow需要再前进一步
            slow = slow.next;
        }
        ListNode newHead = reverse(slow);
        while(newHead!=null) {
            if(newHead.val != head.val){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pre=null,cur=head,next=head;
        while (cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
