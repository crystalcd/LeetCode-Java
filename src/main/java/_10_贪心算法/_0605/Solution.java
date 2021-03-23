package _10_贪心算法._0605;

public class Solution {
    /**
     * 每个地方都种满花
     * 三个0中间可以种花
     * 最左边为0 右边为0可以种花
     * 最右边为0 左边为0可以种花
     * @param flowerbed
     * @param n
     * @return
     */
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
