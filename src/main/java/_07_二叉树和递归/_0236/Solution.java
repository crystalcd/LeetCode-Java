package _07_二叉树和递归._0236;

import data.struct.tree.TreeNode;

public class Solution {
    /**
     * 寻找p和q的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        }
        // 如果p或者q为根节点 ，那么最近公共祖先就是根节点
        if(root==p||root==q) {
            return root;
        }
        // p和q在当前节点左侧是否有最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // p和q在当前节点右侧是否有最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // left和right不为空只能是 p和q分布在root两侧，由于后序遍历 从下至上 所有输出当前节点
        if(left!=null&&right!=null) {
            return root;
        }
        // 左和右都没 则输出null
        if(left==null&&right==null) {
            return null;
        }
        // 左和右 有一个有 则输出有的
        return left==null?right:left;
    }
}
