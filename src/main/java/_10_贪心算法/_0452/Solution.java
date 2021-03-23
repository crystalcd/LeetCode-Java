package _10_贪心算法._0452;

import java.util.Arrays;

public class Solution {
    /**
     * 找出气球的公共部分，有公共部分的可以共用1支箭
     * 贪心 一支箭引爆最多的气球
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        // [1,6] [2,8] [7,12] [10,16]
        if(points.length==0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        Arrays.stream(points).forEach(a -> System.out.println(a[0] + "-" + a[1]));
        int[] temp = points[0];
        int rs = 1;
        for (int i = 0; i < points.length - 1; i++) {
            // 可以合并
            if (points[i+1][0]>=temp[0]&& points[i+1][0]<=temp[1]) {
                temp[0] = Math.max(points[i+1][0],temp[0]);
                temp[1] = Math.min(points[i+1][1],temp[1]);
            } else {// 不可以合并
                ++rs;
                temp = points[i+1];
                System.out.println(temp[0] + "=" + temp[1]);
            }
        }
        return rs;
    }
}
