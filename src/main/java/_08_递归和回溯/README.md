# 递归和回溯
## 回溯
时间复杂度不可能低于O(N!)
穷举整棵决策树无法避免，就是纯暴力穷举
回溯算法框架
```java
result = [];
def backtrack(路径, 选择列表) 
    if 满足结束条件:
        result.add(路径);
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```