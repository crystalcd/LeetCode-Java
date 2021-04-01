package _08_递归和回溯._0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);// 排序
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums,0,track,rs);
        return rs;
    }
    public void backtrack(int[] nums,int start,List<Integer> track,List<List<Integer>> rs) {
        rs.add(new ArrayList<>(track));
        for(int i=start;i<nums.length;i++) {
            // 78题上加上去重 因为已经排过序了，所以当i等于i-1时就可以跳过了
            if(i>start&&nums[i]==nums[i-1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,i+1,track,rs);
            track.remove(track.size()-1);
        }
    }
}
