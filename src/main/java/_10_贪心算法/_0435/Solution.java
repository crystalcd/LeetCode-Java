package _10_贪心算法._0435;

import java.util.Arrays;

public class Solution {
    /**
     * 贪心策略 优先保留结尾小且不相交的区间。
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.stream(intervals).forEach(a -> System.out.println(a[0] + "-" + a[1]));
        int[] rs = intervals[0];
        int num = 0;
        for (int i = 0; i < intervals.length-1; i++) {
            if(rs[1]<=intervals[i+1][0]) {
                rs[1] = intervals[i+1][1];
            }else {
                ++num;
            }
        }

        return num;
    }
}
