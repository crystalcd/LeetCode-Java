# 二叉树和递归
## 典型问题
- 最近公共祖先 236
- 最大深度 节点数 遍历
- 构造二叉树 
    - 根据前序 中序 构造 105

> - [公式编辑器](https://www.codecogs.com/latex/eqneditor.php)
> - 参考[二叉树操作（面试必备）](https://segmentfault.com/a/1190000008850005)


## 二叉树

等比数列 

通项公式 ![等比通项公式](../../images/等比通项公式.png)

求和公式 ![等比数列求和公式](../../images/等比数列求和公式.png)

定义：二叉树的高度为h，总节点为k。

### 特殊

#### 满二叉树

树的每一层都是最大节点数，就是一个等比数列，每层的节点都为![节点计算公式](../../images/节点计算公式.png)，总节点数为![计算节点公式](../../images/计算节点公式.png)

#### 完全二叉树

除最后一层外，其余层都是满的，且最后一层要么是满的，要么是在右边缺少连续节点。

|         | 完全二叉树                                                 | 满二叉树                                     |
| ------- | ---------------------------------------------------------- | -------------------------------------------- |
| 总节点k | ![完全二叉树节点范围](../../images/完全二叉树节点范围.png) | ![h层树总节点](../../images/h层树总节点.png) |
| 树高h   | ![计算树高](../../images/计算树高-6037698.png)             | ![计算树高](../../images/计算树高.png)       |

知识点：

前序遍历列表：第一个元素永远是 【根节点 (root)】
中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
算法思路：

通过【前序遍历列表】确定【根节点 (root)】
将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】

### 节点定义

每个节点有三个属性，首先是该节点的值，然后是该节点的左节点和右节点。

```java
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
```

### 遍历
#### 深度优先遍历

##### 前序遍历
对于当前结点，先输出该结点，然后输出它的左孩子，最后输出它的右孩子
```java
void preorder(TreeNode root){
        if(root==null) {
        return;
        }
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
        }
        // 前序遍历 非递归
        void preorderNonRec(TreeNode root) {
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
```

##### 中序遍历
对于当前结点，先输出它的左孩子，然后输出该结点，最后输出它的右孩子
```java
// 中序遍历 递归
    void inorder(TreeNode root){
            if(root==null) {
            return;
            }
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
            }
            // 中序遍历 非递归
            void inorderNonRec(TreeNode root) {
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
```

##### 后序遍历
对于当前结点，先输出它的左孩子，然后输出它的右孩子，最后输出该结点
```java
// 后序遍历 递归
    void postorder(TreeNode root){
            if(root==null) {
            return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val);
            }
```
#### 广度优先遍历(BFS)
需要使用到队列
将root放入队列，当队列不为空的时候循环，输出当前队列第一个元素，将第一个元素的左孩子放入队列，右孩子放入队列，然后将第一个元素出队列
```java
public void bfs(TreeNode root) {
  if(root==null) {
    return;
  }
  Queue<TreeNode> q= new ArrayDeque<>();
  q.add(root);
  while(!q.isEmpty()) {
    TreeNode cur = q.peek();
    System.out.println(cur.val);
    if(cur.left!=null) {
      q.add(cur.left);
    }
    if(cur.right!=null) {
      q.add(cur.right);
    }
  }
  q.poll();
}
```
### 转换

#### 数组生成二叉树
广度优先遍历数组生成二叉树，对于节点i（从0开始），在数组中为位置为`2*i`，左节点为`2*i+1`，右节点为`2*i+2`。

```java
TreeNode createTree(Integer[] nums) {
    if(nums==null) {
        return null;
    }
    return createNode(nums,0);
}

TreeNode createNode(Integer[] nums,int index){
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
        node.left=createNode(nums,2*index+1);
        node.right=createNode(nums,2*index+2);
        return node;
}

```

## 二叉搜索树（BinarySearchTree BST）

特性

1. 对于BST的每个节点node，左子树节点的值都比node的值要小，右子树节点的值都比node的值要大。
2. 对于BST的每一个节点node，它的左侧子树和右侧子树都是BST。

### 插入

```java
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
```

### 删除

```java
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
```



