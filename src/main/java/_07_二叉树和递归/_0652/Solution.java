package _07_二叉树和递归._0652;

import data.struct.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 652. 寻找重复的子树
     *
     * 前序遍历 存入map 出现重复 将节点加入结果
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> rs = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        find(root,rs,map);
        return rs;
    }
    // 输出当前节点的前序遍历
    public String preorder(TreeNode root) {
        if(root==null) {
            return "";
        }
        return root.val+"#"+ preorder(root.left)+"$"+preorder(root.right);

    }

    public void find(TreeNode root,List<TreeNode> rs, Map<String, Integer> map) {
        if(root==null) {
            return;
        }
        String str = preorder(root);
        if(map.get(str)==null) {
            map.put(str,1);
        }else {
            map.put(str,map.get(str)+1);
            if(map.get(str)==2) {
                rs.add(root);
            }
        }
        find(root.left,rs,map);
        find(root.right,rs,map);
    }
}
