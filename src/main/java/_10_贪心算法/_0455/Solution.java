package _10_贪心算法._0455;

import java.util.Arrays;

public class Solution {
    /**
     * 排序两个数组，每次找最小能满足孩子的饼干。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childNum = 0, cookieNum = 0;
        while(childNum < g.length && cookieNum < s.length) {
            if(g[childNum] <= s[cookieNum]) {
                childNum++;
            }
            cookieNum++;
        }
        return childNum;
    }
}
