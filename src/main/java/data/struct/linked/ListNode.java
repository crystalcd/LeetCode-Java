package data.struct.linked;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 数组转换为链表 返回链表的头节点
     *
     * @param paras
     * @return
     */
    public static ListNode array2Link(int[] paras) {
        ListNode head = new ListNode();
        ListNode node = null;
        ListNode p = head;
        for (int par : paras) {
            node = new ListNode(par);
            p.next = node;
            p = node;
        }
        return head.next;
    }

    /**
     * 链表转换为数组
     *
     * @param head
     * @return
     */
    public static int[] link2array(ListNode head) {
        List<Integer> rsList = new ArrayList();
        while (head != null) {
            rsList.add(head.val);
            head = head.next;
        }
        int[] rs = new int[rsList.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = rsList.get(i);
        }
        return rs;
    }

    /**
     * 链表的前序遍历
     * @param head
     */
    public static void preorder(ListNode head) {
        if(head==null) {
            return;
        }
        System.out.println(head.val);
        preorder(head.next);
    }

    /**
     * 链表的后序遍历
     * @param head
     */
    public static void postorder(ListNode head) {
        if(head==null) {
            return;
        }
        postorder(head.next);
        System.out.println(head.val);
    }
}
