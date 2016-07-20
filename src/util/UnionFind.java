package util;

/**
 * Created by Nano on 2015/11/27.
 */
public class UnionFind {
    private int[] id;
    private int[] sz;
    private int count;

    /**
     * 初始化
     * @param size 触点个数
     */
    public UnionFind(int size) {
        count = size;
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * 返回p所在树的根节点
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    /**
     * 判断p和q是否相连
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 连接两个点p、q
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootOfP = find(p);
        int rootOfQ = find(q);
        if (rootOfP == rootOfQ) return;
        if (sz[rootOfP] < sz[rootOfQ]) {
            id[rootOfP] = rootOfQ;
            sz[rootOfQ] += sz[rootOfP];
        } else {
            id[rootOfQ] = id[rootOfP];
            sz[rootOfP] += sz[rootOfQ];
        }
        count--;
    }

    /**
     * 返回连通分量个数
     * @return
     */
    public int getCount() {
        return count;
    }
}
