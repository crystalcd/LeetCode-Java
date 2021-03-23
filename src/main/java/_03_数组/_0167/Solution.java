package _03_数组._0167;

public class Solution {
    /**
     * 有序 可以使用双指针第三点搜索结果
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (l<r) {
            int sum = numbers[l]+numbers[r];
            if(sum==target) {
                return new int[]{l+1, r+1};
            }else if(sum<target) {
                ++l;
            }else {
                --r;
            }
         }
        return new int[]{-1,-1};
    }
}
