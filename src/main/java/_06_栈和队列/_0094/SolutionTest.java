package _06_栈和队列._0094;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @ParameterizedTest
    @MethodSource("_0094")
    void inorderTraversal(Integer[] arr,Integer[] ans) {
        TreeNode root = createBinaryTree(arr);
        Solution solution = new Solution();
        List<Integer> myans = solution.inorderTraversal(root);
        Integer[] integers = myans.toArray(new Integer[]{});
        Assertions.assertArrayEquals(ans,integers);
        // todo
    }

    static Stream<Arguments> _0094() {
        return Stream.of(
                Arguments.of(new Integer[]{1,null,2,null,null,3},new Integer[]{1,3,2})
                );
    }

    TreeNode createBinaryTreeByArray(Integer[] arr, Integer index) {
        TreeNode tn = null;
        if (index < arr.length) {
            Integer value = arr[index];
            if(value==null){
                return tn;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(arr, 2 * index + 1);
            tn.right = createBinaryTreeByArray(arr, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    /**
     * 根据数据创建二叉树
     * @param arr
     * @return
     */
    TreeNode createBinaryTree(Integer[] arr) {
        return createBinaryTreeByArray(arr, 0);
    }
}