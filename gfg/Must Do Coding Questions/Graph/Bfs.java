package Graph;

import java.util.ArrayList;

public class Bfs {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsUtil(0, visited, res, adj);
        return res;
    }

    static void dfsUtil(int node, boolean[] visited, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        res.add(node);
        for (int i : adj.get(node)) {
            if (visited[i] == false) {
                dfsUtil(i, visited, res, adj);
            }
        }
    }
}
