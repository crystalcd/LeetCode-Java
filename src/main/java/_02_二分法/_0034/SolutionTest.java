package _02_二分法._0034;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0034")
    void searchRange(int[] nums, int target,int[] ans) {
        assertArrayEquals(ans,Solution.searchRange(nums,target));
    }

    static Stream<Arguments> _0034() {
        return Stream.of(
                Arguments.of(new int[]{5,7,7,8,8,10},8,new int[]{3,4})
        );
    }
}