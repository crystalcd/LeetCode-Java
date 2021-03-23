package _10_贪心算法._0135;

public class Solution {
    /**
     * 首先初始化每个人至少有一颗糖，从左往右，右比左大就需要把右更新为左边糖+1，从右往左，如果左比右大且左的糖小于等于右需要把左更新为右+1
     * 这里的贪心策略即为，在每次遍历中，只考虑并更新相邻一 侧的大小关系。
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int sum =0;
        for(int i = 0;i<ratings.length; i++) {
            candies[i] = 1;
            System.out.print(candies[i]+"\n");
        }
        for (int i =0; i<ratings.length-1; i++) {
            if(ratings[i+1]>ratings[i]) {
                candies[i+1] = candies[i]+1;
            }
            System.out.print(candies[i]+"\n");

        }
        for (int i = ratings.length-1; i>0; i--) {
            if(ratings[i-1]>ratings[i]&&candies[i-1]<=candies[i]) {
                candies[i-1]=candies[i] +1;
            }
            System.out.print(candies[i]);

        }
        for(int i=0;i<candies.length;i++) {
            sum +=candies[i];
        }
        return sum;
    }
}
