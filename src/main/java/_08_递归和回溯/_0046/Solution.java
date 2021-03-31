package _08_递归和回溯._0046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**求全排列
     * 回溯法
     *
     * 模版：
     * result = [];
     * def backtrack(路径, 选择列表)
     *     if 满足结束条件:
     *         result.add(路径);
     *         return
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums==null) {
            return null;
        }
        if(nums.length==0) {
            return rs;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track,rs);
        return rs;
    }

    public void backtrack(int[] nums,LinkedList<Integer> track,List<List<Integer>> rs) {
        if(track.size()==nums.length) {
            rs.add(new LinkedList(track));
            return ;
        }
        for (int i=0;i<nums.length;i++) {
            if(track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track,rs);
            track.removeLast();
        }
    }
}
