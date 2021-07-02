package _08_递归和回溯._0463;

public class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int m = grid.length,n = grid[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    System.out.println(i+" "+j);
                    res += dfs(grid,i,j,m,n);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid,int x,int y,int m,int n) {
        System.out.println("搜索位置"+x+","+y);
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==0) {
            return 1;
        }
        if(grid[x][y]==2) {
            return 0;
        }
        int res = 0;
        grid[x][y]=2;
        for (int i=0;i<4;i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res+=dfs(grid,tx,ty,m,n);
        }
        return res;
        /**
         * 搜索位置0,1
         * 搜索位置0,2
         * 搜索位置1,1
         * 搜索位置1,2
         * 搜索位置1,3
         * 搜索位置2,2
         * 搜索位置1,1
         * 搜索位置0,2
         * 搜索位置2,1
         * 搜索位置2,2
         *
         * 搜索位置0,1
         * 搜索位置0,2
         * 搜索位置1,2
         * 搜索位置1,3
         * 搜索位置2,3
         * 搜索位置2,2
         * 搜索位置1,2
         * 搜索位置1,1
         * 搜索位置1,2
         * 搜索位置2,2
         */
    }
}
