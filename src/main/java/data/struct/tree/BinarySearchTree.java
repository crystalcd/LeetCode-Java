package data.struct.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    /**
     * 二叉搜索树插入给定元素 二叉树中不存在等于target的元素
     *
     * @param root
     * @param target
     * @return
     */
    public static TreeNode bstInsert(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (target > root.val) {
            root.right = bstInsert(root.right, target);
        } else if (target < root.val) {
            root.left = bstInsert(root.left, target);
        }
        return root;
    }

    /**
     * 验证树是否为二叉搜索树
     * @param root
     * @return
     */
    public static boolean isValidBst(TreeNode root) {
        return isValidBst(root,null,null);
    }
    static boolean isValidBst(TreeNode root,TreeNode min,TreeNode max) {
        if(root==null) {
            return true;
        }
        if(min!=null&&root.val<=min.val) {
            return false;
        }
        if(max!=null&&root.val>=max.val) {
            return false;
        }
        return isValidBst(root.left,min,root)&&isValidBst(root.right,root,max);
    }

    /**
     * 二叉搜索树删除给定元素
     * @param root
     * @param target
     * @return
     */
    public static TreeNode bstDelete(TreeNode root, int target) {
        if(root==null) {
            return root;
        }
        if(root.val==target) {
            // 情况1 root为叶子节点 直接返回null
            // 情况2 root只有一个子节点 直接返回该子节点
            // 情况3 root右两个子节点 要么返回左子树的最大节点或者返回右子树的最小节点
            if(root.left==null&&root.right==null) {
                return null; // 情况1
            }else if(root.left==null) {
                return root.right; // 情况2
            }else if(root.right==null) {
                return root.left; // 情况2
            }else if(root.left!=null&&root.right!=null) { // 情况3 寻找右子树的最小节点，将值赋值给当前节点，然后去删除右子树的最小节点
                TreeNode minNode = getMin(root.right);
                root.val = minNode.val;
                root.right = bstDelete(root.right,minNode.val);
            }
        }else if(target>root.val) {
            root.right = bstDelete(root.right,target);
        }else if(target<root.val) {
            root.left = bstDelete(root.left,target);
        }
        return root;
    }

    /**
     * 二叉搜索树的最小节点就是最左边的节点
     * @param root
     * @return
     */
    static TreeNode getMin(TreeNode root) {
        while(root.left!=null) {
            root = root.left;
        }
        return root;
    }
}
