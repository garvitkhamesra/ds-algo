package week1.invideo;

/**
 * Created By: garvit
 * Date: 23/5/19
 * Package: PACKAGE_NAME;
 **/

public class QuickUnion {
    private int id[];
    public QuickUnion (int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int root (int num) {
        while (num != id[num]) num = id[num];
        return num;
    }

    public boolean isConnected (int p, int q) {
        if (root(p) == root(q)) return true;
        return false;
    }

    public void union (int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(9);
        quickUnion.union(1,2);
        quickUnion.union(3,4);
        quickUnion.union(6,5);
        quickUnion.union(8,2);
        quickUnion.union(1,6);
        System.out.println(quickUnion.isConnected(1,8));
    }
}
