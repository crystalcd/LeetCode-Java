package _02_二分法._0081;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0081")
    void search(int[] nums,int target,boolean ans) {
        assertEquals(ans,Solution.search(nums,target));
    }

    static Stream<Arguments> _0081() {
        return Stream.of(
                Arguments.of(new int[]{2,5,6,0,0,1,2},0,true),
                Arguments.of(new int[]{1,0,1,1,1},0,true)
        );
    }
}