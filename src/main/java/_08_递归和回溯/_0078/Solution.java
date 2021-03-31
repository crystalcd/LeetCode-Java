package _08_递归和回溯._0078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [1,2,3]
 *
 */
public class Solution {

    /**
     * 求子集 回溯
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
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> rs = new ArrayList<>();
         List<Integer> track = new ArrayList<>();
         backtrack(nums,0,track,rs);
         return rs;
     }

     public void backtrack(int[] nums,int start,List<Integer> track,List<List<Integer>> rs) {
         rs.add(new ArrayList<>(track));
         System.out.println(rs.toString());
         for(int i = start;i<nums.length;i++) {
             track.add(nums[i]);
             backtrack(nums,i+1,track,rs);
             track.remove(track.size()-1);
         }
     }
}
