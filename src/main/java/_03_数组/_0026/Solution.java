package _03_数组._0026;

public class Solution {
    /**
     * 两个指针 ，一个用来记录不重复的最后一个位置，另一个用来遍历
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                if (i != index) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
            }
        }
        return ++index;
    }
}
