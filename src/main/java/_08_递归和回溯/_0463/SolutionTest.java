package _08_递归和回溯._0463;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0463")
    void testIslandPerimeter(int[][] grid, int ans) {
        Solution so = new Solution();
        assertEquals(ans,so.islandPerimeter(grid));
    }

    static Stream<Arguments> _0463() {
        return Stream.of(
                Arguments.of(new int[][]{{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}},16)
        );
    }

}