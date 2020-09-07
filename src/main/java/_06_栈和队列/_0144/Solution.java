package _06_栈和队列._0144;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        preorder(root,rs);
        return rs;
    }

    public void preorder(TreeNode root,List<Integer> rs){
        if(root!=null) {
            rs.add(root.val);
            preorder(root.left,rs);
            preorder(root.right,rs);
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