import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by dot on 12/2/20 8:36 PM
 * Package: PACKAGE_NAME
 */
public class GraphTraversal {
    private int vertices;
    private LinkedList<Integer> edges[];

    GraphTraversal(int vertices) {
        this.vertices = vertices;

        edges = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            edges[i] = new LinkedList();
        }
    }

    private void addEdge(int vertex, int nextVertex) {
        edges[vertex].add(nextVertex);
    }

    private void traversal(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> i = edges[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                traversal(n, visited);
        }
    }

    void initialize(int v) {
        boolean visited[] = new boolean[vertices];
        traversal(v, visited);
    }

    public static void main(String args[]) {
        GraphTraversal graph = new GraphTraversal(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.initialize(0);
    }
}