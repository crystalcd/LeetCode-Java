package _10_贪心算法._0605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int rs = 0;
        for(int i=0; i< flowerbed.length; i++) {
            if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)) {
                ++rs;
                flowerbed[i]=1;
            }
        }
        System.out.println(rs);
        return rs>=n;
    }
}
