package _10_贪心算法._0435;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.ParameterizedType;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0435")
    void eraseOverlapIntervals(int[][] intervals, int ans) {
        Assertions.assertEquals(ans,Solution.eraseOverlapIntervals(intervals));
    }

    static Stream<Arguments> _0435() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}, 2)
        );
    }
}