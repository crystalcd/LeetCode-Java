package _09_动态规划._0053;

import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public int maxSubArray(int[] nums) {
        return dp(nums, nums.length - 1);
    }

    // 以第i个数结尾的连续子数组
    public int dp(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        int max = Math.max(dp(nums, i - 1) + nums[i], nums[i]);
        System.out.println("i="+i+",max="+max);
        Map<Integer,String> map = new HashMap<>();

        return max;

    }

}
