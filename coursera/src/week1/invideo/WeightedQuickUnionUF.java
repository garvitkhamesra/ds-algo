package week1.invideo;

public class WeightedQuickUnionUF {
    private int id[];
    private int size[];
    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        if (root(p) == root(q)) return true;
        return false;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    public static void main(String[] args) {
        week1.invideo.WeightedQuickUnionUF weightedQuickUnionUF = new week1.invideo.WeightedQuickUnionUF(9);
        weightedQuickUnionUF.union(1,2);
        weightedQuickUnionUF.union(3,4);
        weightedQuickUnionUF.union(6,5);
        weightedQuickUnionUF.union(8,2);
        weightedQuickUnionUF.union(1,6);
        System.out.println(weightedQuickUnionUF.isConnected(1,8));
    }
}
