package _03_数组._0076;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0076")
    void minWindow(String s,String t,String expected) {
        String s1 = new Solution().minWindow(s, t);
        assertEquals(expected,s1);
    }

    static Stream<Arguments> _0076() {
        return Stream.of(
                Arguments.of("aa","aa","aa")
        );
    }
}