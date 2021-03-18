package _07_二叉树和递归._0257;

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
    @MethodSource("_0257")
    void binaryTreePaths(Integer[] nums, String[] ans) {
        TreeNode root = arr2Tree(nums);
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

    /**
     * [1,2,3,null,5]
     * 1
     * 2     3
     * null 5
     *
     * @param nums
     * @return
     */
    TreeNode arr2Tree(Integer[] nums) {
        return createNode1(nums, 0);
    }
    // 根节点从1开始
    TreeNode createNode(Integer[] nums,int index){
        // index超出数组长度 返回null
        if(index>nums.length) {
            return null;
        }
        // index为1时创建跟节点
        Integer value = nums[index-1];
        if(value == null) {
            return null;
        }
        TreeNode node=new TreeNode(value);
        node.left=createNode(nums,2*index);
        node.right=createNode(nums,2*index+1);
        return node;
    }

    // 根节点从0开始
    TreeNode createNode1(Integer[] nums,int index){
        // index超出数组长度 返回null
        if(index>nums.length-1) {
            return null;
        }
        // index为1时创建跟节点
        Integer value = nums[index];
        if(value == null) {
            return null;
        }
        TreeNode node=new TreeNode(value);
        node.left=createNode1(nums,2*index+1);
        node.right=createNode1(nums,2*index+2);
        return node;
    }


    TreeNode createTree2(List<TreeNode> nodes) {
        if (nodes.size() > 0) {
            for (int i = 0; i < nodes.size() / 2 - 1; i++) {
                // 左子树
                if (nodes.get(2 * i + 1) != null) {
                    nodes.get(i).left = nodes.get(2 * i + 1);
                }
                // 右子树
                if (nodes.get(2 * i + 2) != null) {
                    nodes.get(i).right = nodes.get(2 * i + 2);
                }
            }
            int lastIndex = nodes.size() / 2 - 1;
            // 左节点
            nodes.get(lastIndex).left = nodes.get(2 * lastIndex + 1);
            // 只有数组长度为奇数是才有右节点
            if (nodes.size() % 2 == 1) {
                nodes.get(lastIndex).right = nodes.get(2 * lastIndex + 2);
            }
        }
        return nodes.get(0);
    }
}