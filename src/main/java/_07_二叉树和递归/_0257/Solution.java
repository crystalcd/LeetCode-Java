package _07_二叉树和递归._0257;

import data.struct.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    List<String> rs = new ArrayList<>();

    /**
     * 257. 二叉树的所有路径
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        path(root,sb);
        return rs;
    }

    public void path(TreeNode root,StringBuilder sb) {
        if(root==null) {
            return ;
        }
        if("".equals(sb.toString())) {
            sb.append(root.val);
        }else {
            sb.append("->").append(root.val);
        }
        if(root.left==null&&root.right==null) {
            rs.add(sb.toString());
            return;
        }

        path(root.left,new StringBuilder(sb));
        path(root.right,new StringBuilder(sb));
    }
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
