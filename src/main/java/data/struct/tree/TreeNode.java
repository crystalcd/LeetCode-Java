package data.struct.tree;

import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 前序遍历 递归
    public static void preorder(TreeNode root){
        if(root==null) {
            return;
        }
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    // 前序遍历 非递归
    public static void preorderNonRec(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println("前序遍历非递归");
        Stack<TreeNode> s = new Stack<>();
        while(!s.empty()||root!=null) {// 栈中有元素或者root还是节点
            while(root!=null) {
                System.out.print(root.val); // 输出当前节点
                s.push(root);
                root = root.left; // 然后输出左孩子
            } // 循环结束 左孩子输出结束
            root = s.pop().right; // 输出右孩子

        }
    }

    // 中序遍历 递归
    public static void inorder(TreeNode root){
        if(root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }
    // 中序遍历 非递归
    public static void inorderNonRec(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println("中序遍历非递归");
        Stack<TreeNode> s = new Stack<>();
        while(!s.empty()||root!=null) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            } // 循环结束 左孩子输出结束
            System.out.print(s.peek().val); // 左孩子输出完毕 接着输出当前节点
            root = s.pop().right;
        }
    }

    // 后序遍历 递归
    public static void postorder(TreeNode root){
        if(root==null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }

    public static void postorderNonRec(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        while(root.left!=null||root.right!=null) {
            s.push(root);
        }
        System.out.print(s.pop().val);

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
    public static TreeNode arr2Tree(Integer[] nums) {
        return createNode1(nums, 0);
    }
    // 根节点从1开始
    TreeNode createNode(Integer[] nums, int index){
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
    public static TreeNode createNode1(Integer[] nums, int index){
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


    public static TreeNode createTree2(List<TreeNode> nodes) {
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
