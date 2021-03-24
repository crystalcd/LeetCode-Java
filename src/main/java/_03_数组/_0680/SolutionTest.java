package _03_数组._0680;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0680")
    void validPalindrome(String s, boolean ans) {
        assertEquals(Solution.validPalindrome1(s),ans);
    }

    static Stream<Arguments> _0680() {
        return Stream.of(
                Arguments.of("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga", true)
        );
    }
}