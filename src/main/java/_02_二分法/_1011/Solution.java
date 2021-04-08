package _02_二分法._1011;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class Solution {
    /**
     * 就是在连续的空间线性搜索，这就是二分查找可以发挥作用的标志。
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int l=getMax(weights),r=sum(weights),mid;
        while(l<=r) {
            mid = l+(r-l)/2;
            if(canFinish(weights,D,mid)) { // 要求最小 ，左侧区间
                r = mid-1;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
    public int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for(int weight:weights) {
            max = Math.max(max,weight);
        }
        return max;
    }

    public int sum(int[] weights) {
        int sum = 0;
        for(int weigth:weights) {
            sum+=weigth;
        }
        return sum;
    }

    public boolean canFinish(int[] weights,int D,int cap) {
        int i=0; // 记录搬运了多少东西
        for(int day=0;day<D;day++) {
            int maxCap = cap;
            while((maxCap-=weights[i])>=0) {
                i++;
                if(i==weights.length){
                    return true;
                }
            }
        }
        return false;
    }
}
