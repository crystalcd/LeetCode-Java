package _08_递归和回溯._0130;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0130")
    void solve(char[][] strs) {
        new Solution().solve(strs);
    }

    static Stream<Arguments> _0130() {
        return Stream.of(
                Arguments.of(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}})
        );
    }
}