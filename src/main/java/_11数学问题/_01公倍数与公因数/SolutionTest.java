package _11数学问题._01公倍数与公因数;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("gcdtest")
    void gcd(int a,int b,int ans) {
        Solution solution = new Solution();
        assertEquals(ans,solution.gcdRec(a,b));
        assertEquals(ans,solution.gcd(a,b));
    }

    static Stream<Arguments> gcdtest() {
        return Stream.of(
                Arguments.of(10,6,2),
                Arguments.of(6,10,2)
        );
    }
}