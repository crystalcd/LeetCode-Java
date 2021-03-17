package _07_二叉树和递归._0257;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rs = new ArrayList<>();
        if(root == null) {
            return rs;
        }
        if(root.left == null && root.right == null) {
            rs.add(String.valueOf(root.val));
            return rs;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        for (String leftPath:leftPaths) {
            StringBuilder leftSb = new StringBuilder(String.valueOf(root.val));
            leftSb.append("->");
            leftSb.append(leftPath);
            rs.add(leftSb.toString());
        }
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String rightPath:rightPaths) {
            StringBuilder rightSb = new StringBuilder(String.valueOf(root.val));
            rightSb.append("->");
            rightSb.append(rightPath);
            rs.add(rightSb.toString());
        }
        return rs;

    }

    public List<String> binaryTreePaths1(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<String> rs = new ArrayList<>();
        binaryTree(root, rs, "");
        return rs;

    }
    public void binaryTree(TreeNode root, List<String> list, String str) {
        if(root == null) {
            return;
        }
        String rootStr ="".equals(str)? (""+root.val):("->"+ root.val);
        str += rootStr;
        if(root.left == null && root.right == null) {
            list.add(str);
            // str = "";
        }
        binaryTree(root.left, list, str);
        binaryTree(root.right, list, str);

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
