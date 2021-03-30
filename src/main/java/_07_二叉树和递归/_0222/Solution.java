package _07_二叉树和递归._0222;

import data.struct.tree.TreeNode;

public class Solution {
    /**
     * 求完全二叉树节点 ，跟二叉树一样  遍历所有节点
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    /**
     * 完全二叉树的h-1层为满二叉树 只需要求满二叉树加上最后一层节点
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        int hl=0,hr=0;
        TreeNode l =root,r=root;
        while (l!=null) {
            l=l.left;
            hl++;
        }
        while (r!=null) {
            r=r.right;
            hr++;
        }
        if(hl==hr) {
            return (int)Math.pow(2,hl)-1;
        }
        return 1+countNodes1(root.left)+countNodes1(root.right);
    }

}
