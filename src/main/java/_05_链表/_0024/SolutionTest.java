package _05_链表._0024;

import data.struct.linked.ListNode;
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
        ListNode paraHead = ListNode.array2Link(para);
        Solution solution = new Solution();
        ListNode rsHead = solution.swapPairs(paraHead);
        int[] myAns = ListNode.link2array(rsHead);
        assertArrayEquals(ans, myAns);
    }

    static Stream<Arguments> _0024() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5}),
                Arguments.of(new int[]{}, new int[]{})
        );// 添加测试案例可以拷贝上面的数据修改
    }


}