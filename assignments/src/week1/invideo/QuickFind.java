package week1.invideo;

/**
 * Created By: garvit
 * Date: 23/5/19
 * Package: PACKAGE_NAME;
 **/

public class QuickFind {
    /*Eager Approach*/
    private int id[];
    public QuickFind(int n) {
         id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        if (id[p] == id[q]) return true;
        return false;
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (pid == id[i]) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(9);
        quickFind.union(1,2);
        quickFind.union(3,4);
        quickFind.union(6,5);
        quickFind.union(8,2);
        quickFind.union(1,6);
        System.out.println(quickFind.isConnected(1,8));
    }
}
