package _06_栈和队列._0094;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        inorder(root, rs);
        return rs;
    }

    public void inorder(TreeNode node, List<Integer> rs) {
        if (node!=null) {
            inorder(node.left, rs);
            rs.add(node.val);
            inorder(node.right, rs);
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