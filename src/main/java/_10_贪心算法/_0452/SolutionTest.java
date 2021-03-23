package _10_贪心算法._0452;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0452")
    void findMinArrowShots(int[][] points, int ans) {
        assertEquals(Solution.findMinArrowShots(points),ans);
    }

    static Stream<Arguments> _0452() {
        return Stream.of(
                Arguments.of(new int[][]{{10,16},{2,8},{1,6},{7,12}},  2),
                Arguments.of(new int[][]{{1,3}},  1),
                Arguments.of(new int[][]{{1,2},{4,5},{1,5}},  2),
                Arguments.of(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}},  2)

        );
    }
}