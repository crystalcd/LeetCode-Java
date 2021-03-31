package _08_递归和回溯._0078;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0078")
    void subsets(int[] nums) {
        List<List<Integer>> subsets = new Solution().subsets(nums);

    }

    static Stream<Arguments> _0078() {
        return Stream.of(
              Arguments.of(new int[]{1,2,3})
        );
    }
}