package _02_二分法._1011;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_1011")
    void shipWithinDays(int[] weights,int D,int expected) {
        int actual = new Solution().shipWithinDays(weights, D);
        assertEquals(expected,actual);
    }

    static Stream<Arguments> _1011() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,10},5,15)
        );
    }
}