package _09_动态规划._0053;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0053")
    void maxSubArray(int[] nums,int expected) {
        int i = new Solution().maxSubArray(nums);
        assertEquals(expected,i);
    }

    static Stream<Arguments> _0053() {
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4},6)
        );
    }
}