package data.struct.linked;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void array2Link() {
    }

    @Test
    void link2array() {
    }

    @ParameterizedTest
    @MethodSource("_listnode")
    void preorder(int[] nums) {
        ListNode listNode = ListNode.array2Link(nums);
        ListNode.preorder(listNode);
    }

    @ParameterizedTest
    @MethodSource("_listnode")
    void postorder(int[] nums) {
        ListNode listNode = ListNode.array2Link(nums);
        ListNode.postorder(listNode);
    }

    static Stream<Arguments> _listnode() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3,4,5,6})
        );
    }
}