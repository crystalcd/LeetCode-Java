package data.struct.uf;

/**
 * 并查集 数据结构
 * 这里所说的「连通」是一种等价关系，也就是说具有如下三个性质：
 * 1、自反性：节点p和p是连通的。
 * 2、对称性：如果节点p和q连通，那么q和p也连通。
 * 3、传递性：如果节点p和q连通，q和r连通，那么p和r也连通。
 *
 * Union-Find 算法的复杂度可以这样分析：构造函数初始化数据结构需要 O(N) 的时间和空间复杂度；
 * 连通两个节点union、判断两个节点的连通性connected、计算连通分量count所需的时间复杂度均为 O(1)。
 */
public class UF {
    // 记录连通分量
    private int count;
    // 节点x的父节点为parents[x]
    private int[] parents;

    // 节点x的重量 为了优化是树更平衡 提高时间效率，将小的树往大的树插入，而不是随便插入
    private int[] sizes;

    /** 构造函数 n为图的总节点数 */
    public UF(int n) {
        this.count = n;
        // 初始每个节点根自己连通
        parents = new int[n];
        sizes = new int[n];
        for(int i=0;i<n;i++) {
            parents[i]=i;
            sizes[i]=1;
        }
    }


    /**
     * 将p和q连接
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) {
            return;
        }
        // 小树合并到大树
        if(sizes[pRoot]<sizes[qRoot]) {
            parents[pRoot] = qRoot;
            sizes[pRoot]+=sizes[qRoot];
        }else {
            parents[qRoot] = pRoot;
            sizes[qRoot]+=sizes[pRoot];
        }
        this.count--; // 连通分量减少1
    }

    /**
     * 返回某个节点的跟节点
     * @param x
     * @return
     */
    private int find(int x) {
        while(this.parents[x]!=x) {
            // 路径压缩
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    /**
     * 判断p和q是否连通
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot==qRoot;
    }

    /**
     * 返回图中有多少连通分量
     * @return
     */
    public int count() {
        return this.count;
    }
}
