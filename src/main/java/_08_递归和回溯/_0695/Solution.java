package _08_递归和回溯._0695;

public class Solution {
    /**
     * 695. 岛屿的最大面积
     *
     * 深度优先搜索
     * 一般来说，深度优先搜索类型 的题可以分为主函数和辅函数，主函数用于遍历所有的搜索位置，
     * 判断是否可以开始搜索，如果 可以即在辅函数进行搜索。辅函数则负责深度优先搜索的递归调用。
     * 当然，我们也可以使用栈(stack)实现深度优先搜索，但因为栈与递归的调用原理相同，
     * 而递归相对便于实现，因此刷题时 笔者推荐使用递归式写法，同时也方便进行回溯(见下节)。
     * 不过在实际工程上，直接使用栈可 能才是最好的选择，一是因为便于理解，二是更不易出现递归栈满的情况。
     */
    int[] dirct={-1,0,1,0,-1}; // 相邻两个表示方向 左上右下
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0||grid[0].length==0) {
            return 0;
        }
        int maxArea = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) { // 找到一个土地， 搜索周围形成的土地大小
                    maxArea = Math.max(maxArea, area(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    public int area(int[][] grid,int r,int c) {
        if(grid[r][c]==0) {
            return 0;
        }
        grid[r][c] = 0;
        int x,y,area=1;
        for(int i=0;i<4;i++) {
            x = r+dirct[i];
            y= c +dirct[i+1];
            if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length) {
                area+=area(grid,x,y);
            }
        }
        return area;
    }
}
