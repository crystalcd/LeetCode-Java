package _02_二分法._0034;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = lowerBound(nums, target);
        int r = upperBound(nums, target);
        return new int[]{l,r};
    }

    public static int lowerBound(int[] nums, int target) {
        int rs = -1;
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                rs = mid;
                r = mid - 1; // 向左移动找到左边界
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return rs;
    }

    public static int upperBound(int[] nums, int target) {
        int rs = -1;
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                rs = mid;
                l = mid + 1; // 向右移动找到有边界
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return rs;
    }
}
