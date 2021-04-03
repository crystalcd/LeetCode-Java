package _08_递归和回溯._0130;

public class Solution {

    /**
     * 使用并查集 将四周的所有的格子根虚拟节点dummy连接，这些都是肯定不能被围住的，
     * 然后再从出了四周的内部寻找，当寻找到'O' 节点a时，判断它的上下左右四个节点是否为'O'，如果是，
     * 就将该节点和a连通，最后重新遍历二维数组，将跟dummy不连通的替换成'X'
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        //二维坐标 (x,y) 可以转换成 x * n + y 这个数（m 是棋盘的行数，n 是棋盘的列数）。敲黑板，这是将二维坐标映射     // 到 一维的常用技巧。
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if (board[m - 1][i] == 'O') {
                uf.union((m - 1) * n + i, dummy);
            }
        }
        int[][] direct = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = direct[k][0] + i;
                        int y = direct[k][1] + j;
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    class UF {
        // 记录连通分量
        private int count;
        // 节点x的父节点为parents[x]
        private int[] parents;

        // 节点x的重量 为了优化是树更平衡 提高时间效率，将小的树往大的树插入，而不是随便插入
        private int[] sizes;

        /**
         * 构造函数 n为图的总节点数
         */
        public UF(int n) {
            this.count = n;
            // 初始每个节点根自己连通
            parents = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }


        /**
         * 将p和q连接
         *
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            // 小树合并到大树
            if (sizes[pRoot] < sizes[qRoot]) {
                parents[pRoot] = qRoot;
                sizes[pRoot] += sizes[qRoot];
            } else {
                parents[qRoot] = pRoot;
                sizes[qRoot] += sizes[pRoot];
            }
            this.count--; // 连通分量减少1
        }

        /**
         * 返回某个节点的跟节点
         *
         * @param x
         * @return
         */
        private int find(int x) {
            while (this.parents[x] != x) {
                // 路径压缩
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        /**
         * 判断p和q是否连通
         *
         * @param p
         * @param q
         * @return
         */
        public boolean connected(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            return pRoot == qRoot;
        }

        /**
         * 返回图中有多少连通分量
         *
         * @return
         */
        public int count() {
            return this.count;
        }
    }

}
