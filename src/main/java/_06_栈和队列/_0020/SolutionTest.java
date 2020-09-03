package _06_栈和队列._0020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0020")
    void isValid(String para,boolean ans) {
        Solution solution = new Solution();
        boolean myans = solution.isValid(para);
        Assertions.assertEquals(ans,myans);
    }

    static Stream<Arguments> _0020() {
        return Stream.of(
                Arguments.of("()",true),
                Arguments.of("()[]{}",true),
                Arguments.of("(]",false),
                Arguments.of("([)]",false),
                Arguments.of("{[]}",true),
                Arguments.of("]",false),
                Arguments.of("][",false),
                Arguments.of("(){}}{",false),
                Arguments.of("(])",false)
        );
    }
}