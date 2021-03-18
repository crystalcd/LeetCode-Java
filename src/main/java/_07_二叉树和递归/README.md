# 二叉树和递归

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

```java
void preorder(TreeNode root){
        if(root!=null) {
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
}
```

##### 中序遍历

```java
void inorder(TreeNode root){
        if(root!=null) {
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
        }
}
```

##### 后序遍历

```java
void postorder(TreeNode root){
        if(root!=null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val);
        }
}
```
#### 广度优先遍历
todo
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