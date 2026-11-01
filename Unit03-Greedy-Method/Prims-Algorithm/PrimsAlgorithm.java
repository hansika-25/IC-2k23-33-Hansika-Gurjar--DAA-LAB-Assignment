import java.util.Scanner;

public class PrimsAlgorithm {

    static final int INF = 999999;

    public static void prims(int[][] graph, int vertices) {
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = INF;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = -1;
            int min = INF;

            for (int v = 0; v < vertices; v++) {
                if (!mstSet[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }

            if (u == -1) {
                System.out.println("Graph is disconnected. MST cannot be formed.");
                return;
            }

            mstSet[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int totalWeight = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i +
                    " : " + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix (0 for no edge):");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        prims(graph, vertices);

        sc.close();
    }
}