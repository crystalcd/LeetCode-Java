package _07_二叉树和递归._0105;

import data.struct.tree.TreeNode;

public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    static TreeNode build(int[] preorder, int[] inorder, int rootl, int rootr, int l, int r) {
        if (l > r || rootl > rootr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootl]);
        int index = 0;
        for (int i = l; i <= r; i++) {
            if (preorder[rootl] == inorder[i]) {
                index = i;
            }
        }
        int leftnum = index-l;
        root.left = build(preorder, inorder, rootl + 1, rootl + leftnum, l, index - 1);
        root.right = build(preorder, inorder, rootl + leftnum + 1, rootr, index + 1, r);
        return root;
    }
}