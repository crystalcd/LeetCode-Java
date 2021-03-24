package _05_链表._0142;

import data.struct.linked.ListNode;

public class Solution {
    /**
     * Floyd 判圈法
     * 如果有限状态机、迭代函数或者链表存在环，那么一定存在一个起点可以到达某个环的某处(这个起点也可以在某个环上)。
     *
     * 初始状态下，假设已知某个起点节点为节点head。现设两个指针fast和slow，将它们均指向S。
     *
     * 接着，同时让t和h往前推进，但是二者的速度不同：slow每前进1步，fast前进2步。只要二者都可以前进而且没有相遇，就如此保持二者的推进。当fast无法前进，即到达某个没有后继的节点时，就可以确定从S出发不会遇到环。反之当fast与slow再次相遇时，就可以确定从S出发一定会进入某个环，设其为环C。
     *
     * 如果确定了存在某个环，就可以求此环的起点与长度。
     *
     * 上述算法刚判断出存在环C时，显然slow和fast位于同一节点，设其为节点M。显然，仅需令fast不动，而slow不断推进，最终又会返回节点M，统计这一次t推进的步数，显然这就是环C的长度。
     *
     * 为了求出环C的起点，只要令fast仍均位于节点M，而令slow返回起点节点S，此时fast与slow之间距为环C长度的整数倍。随后，同时让t和h往前推进，且保持二者的速度相同：fast每前进1步，slow前进1步。持续该过程直至fast与slow再一次相遇，设此次相遇时位于同一节点P，则节点P即为从节点S出发所到达的环C的第一个节点，即环C的一个起点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 第一次相遇
        do {
            if(fast==null||fast.next==null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast!=slow);
        // 第二次相遇
        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
