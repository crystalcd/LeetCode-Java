package _05_链表._0019;

import data.struct.linked.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0019")
    void removeNthFromEnd(int[] para, int n, int[] ans) {
        ListNode head = ListNode.array2Link(para);
        Solution solution = new Solution();
        ListNode myAnsHead = solution.removeNthFromEnd(head, n);
        int[] myans = ListNode.link2array(myAnsHead);
        assertArrayEquals(ans,myans);
    }

    static Stream<Arguments> _0019() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{1}, 1, new int[]{})
        );
    }


}