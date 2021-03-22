package _03_数组._0283;

public class Solution {
    // 先将非0的填冲到数组前面，然后其余的补0
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i = index;i<nums.length;i++) {
            nums[i] = 0;
        }
    }

    /**
     * 优化
     * 0,1,0,3,12
     * 两个指针，一个指针记录非0位置后为0的index，另一个指针遍历数组i，遇到非0就跟index互换位置，index++
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                if(index!=i) { // 位置一样不互换位置
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
    }
}
