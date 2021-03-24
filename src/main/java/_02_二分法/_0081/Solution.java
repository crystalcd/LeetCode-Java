package _02_二分法._0081;

import org.junit.jupiter.params.ParameterizedTest;

public class Solution {
    /**
     * [2,5,6,0,0,1,2]
     *
     * @param nums
     * @param target
     * @return
     */
    public static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {// 找到直接返回
                return true;
            }
            if (nums[l] == nums[mid]) { // 无法判断重复的数在左边还是右边,将左向右移动后再比较
                ++l;
            } else if (nums[mid] <= nums[r]) {// 右部有序
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // 左部有序
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}
