package _07_二叉树和递归._0105;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0105")
    void buildTree(int[] preorder,int[] inorder) {
        Solution.buildTree(preorder,inorder);
        int inf = (int)2e8;
        List<Integer> a = new ArrayList<>();
        System.out.println(inf);
    }

    static Stream<Arguments> _0105() {
        return Stream.of(
                Arguments.of(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7})
        );
    }
}