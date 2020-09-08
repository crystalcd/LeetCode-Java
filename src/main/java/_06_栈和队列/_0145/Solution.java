package _06_栈和队列._0145;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs= new ArrayList<>();
        postorder(root,rs);
        return rs;
    }

    public void postorder(TreeNode node, List<Integer> rs) {
        if (node != null) {
            postorder(node.left,rs);
            postorder(node.right,rs);
            rs.add(node.val);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}