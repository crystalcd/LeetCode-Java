package _05_链表._0024;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0024")
    void swapPairsTest(int[] para, int[] ans) {
        ListNode paraHead = array2Link(para);
        Solution solution = new Solution();
        ListNode rsHead = solution.swapPairs(paraHead);
        int[] myAns = link2array(rsHead);
        assertArrayEquals(ans, myAns);
    }

    static Stream<Arguments> _0024() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5}),
                Arguments.of(new int[]{}, new int[]{})
        );// 添加测试案例可以拷贝上面的数据修改
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