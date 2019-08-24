package week1.invideo;

public class WeightedQuickUnion {
    private int id[];
    private int size[];
    public WeightedQuickUnion (int n) {
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
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(9);
        weightedQuickUnion.union(1,2);
        weightedQuickUnion.union(3,4);
        weightedQuickUnion.union(6,5);
        weightedQuickUnion.union(8,2);
        weightedQuickUnion.union(1,6);
        System.out.println(weightedQuickUnion.isConnected(1,8));
    }
}
