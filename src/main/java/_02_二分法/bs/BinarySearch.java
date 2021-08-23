package _02_二分法.bs;

public class BinarySearch {

    public int lower_bound(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid]==target) {
                r = mid-1;
            }else if(nums[mid]>target) {
                r= mid -1;
            }else {
                l= mid +1;
            }
        }
        if(l>=nums.length||nums[l]!=target) {
            return -1;
        }
        return l;
    }

    public int upper_bound(int[] nums,int target) {
        int l=0,r=nums.length-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid]==target) {
                l = mid +1;
            }else if(nums[mid]>target) {
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        if(r<0||nums[r]!=target) {
            return -1;
        }
        return r;
    }
}
