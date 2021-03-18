package _07_二叉树和递归._0257;

import data.struct.tree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0257")
    void binaryTreePaths(Integer[] nums, String[] ans) {
        TreeNode root = TreeNode.arr2Tree(nums);
        System.out.println("前序遍历");
        TreeNode.preorder(root);
        TreeNode.preorderNonRec(root);
        System.out.println("\n中序遍历");
        TreeNode.inorder(root);
        TreeNode.inorderNonRec(root);
        System.out.println("\n后序遍历");
        TreeNode.postorder(root);
        Solution solution = new Solution();
        List<String> strings = solution.binaryTreePaths1(root);
        assertArrayEquals(ans,strings.toArray());
    }

    static Stream<Arguments> _0257() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, null, 5}, new String[]{"1->2->5", "1->3"}),
                Arguments.of(new Integer[]{1}, new String[]{"1"})
        );
    }


}