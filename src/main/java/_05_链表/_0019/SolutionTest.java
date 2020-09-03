package _05_链表._0019;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0019")
    void removeNthFromEnd(int[] para, int n, int[] ans) {
        ListNode head = array2Link(para);
        Solution solution = new Solution();
        ListNode myAnsHead = solution.removeNthFromEnd(head, n);
        int[] myans = link2array(myAnsHead);
        assertArrayEquals(ans,myans);
    }

    static Stream<Arguments> _0019() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{1}, 1, new int[]{})
        );
    }

    /**
     * 数组转换为链表 返回链表的头节点
     *
     * @param paras
     * @return
     */
    ListNode array2Link(int[] paras) {
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
    int[] link2array(ListNode head) {
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
}