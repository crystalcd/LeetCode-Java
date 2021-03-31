package _05_链表._0092;

import data.struct.linked.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0092")
    void reverseBetween(int[] input,int left,int right, int[] output) {
        ListNode head = ListNode.array2Link(input);
        ListNode rs = new Solution().reverseBetween1(head, left, right);
        int[] actuals = ListNode.link2array(rs);
        assertArrayEquals(output,actuals);

    }

    @ParameterizedTest
    @MethodSource("_0092_1")
    void reverseBetween1(int[] input,int[] output) {
        ListNode head = ListNode.array2Link(input);
        ListNode rs = new Solution().reverseBetween1(head);
        int[] actuals = ListNode.link2array(rs);
        assertArrayEquals(output,actuals);
    }

    @ParameterizedTest
    @MethodSource("_0092_3")
    void reverseBetween1(int[] input,int[] output,int n) {
        ListNode head = ListNode.array2Link(input);
        ListNode rs = new Solution().reverseBetween1(head,n);
        int[] actuals = ListNode.link2array(rs);
        assertArrayEquals(output,actuals);
    }

    static Stream<Arguments> _0092_1() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5,4,3,2,1}),
                Arguments.of(new int[]{3, 5},new int[]{5,3})
        );
    }


    static Stream<Arguments> _0092() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2,4, new int[]{1,4,3,2,5}),
                Arguments.of(new int[]{3, 5}, 1,2, new int[]{5,3})
        );
    }

    static Stream<Arguments> _0092_3() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3,2,1,4,5},3)
        );
    }
}