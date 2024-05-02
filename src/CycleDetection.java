import java.util.*;

public class CycleDetection {

    static class Graph {
        private int V;
        private LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            V = vertices;
            adjList = new LinkedList[V];
            for (int i = 0; i < V; ++i)
                adjList[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adjList[v].add(w);
        }

        void DFS(int v, boolean[] visited, boolean[] finished) {
            if (finished[v])
                return;

            if (visited[v]) {
                System.out.println("Cycle found");
                return;
            }

            visited[v] = true;

            for (int neighbor : adjList[v]) {
                DFS(neighbor, visited, finished);
            }

            finished[v] = true;
        }

        void detectCycle() {
            boolean[] visited = new boolean[V];
            boolean[] finished = new boolean[V];

            for (int v = 0; v < V; v++) {
                visited[v] = false;
                finished[v] = false;
            }

            for (int v = 0; v < V; v++) {
                DFS(v, visited, finished);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(16);

        // Adding edges to the graph
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 4);
        g.addEdge(3, 8);
        g.addEdge(3, 15);
        g.addEdge(9, 3);
        g.addEdge(9, 6);
        g.addEdge(13, 6);
        g.addEdge(8, 13);
        g.addEdge(10, 6);
        g.addEdge(11, 10);
        g.addEdge(12, 11);
        g.addEdge(11, 14);
        g.addEdge(11, 7);
        g.addEdge(12, 10);
        g.addEdge(7, 12);
        g.addEdge(14, 10);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        g.detectCycle();
    }
}
