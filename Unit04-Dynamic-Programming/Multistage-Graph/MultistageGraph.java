import java.util.Arrays;
import java.util.Scanner;

public class MultistageGraph {

    static final int INF = Integer.MAX_VALUE;

    public static int shortestPath(int[][] graph, int n, int source, int destination) {
        int[] cost = new int[n];
        int[] path = new int[n];

        Arrays.fill(cost, INF);
        Arrays.fill(path, -1);

        cost[destination] = 0;

        // Process vertices in reverse order
        for (int u = destination - 1; u >= source; u--) {
            for (int v = u + 1; v < n; v++) {
                if (graph[u][v] != 0 && cost[v] != INF) {
                    int newCost = graph[u][v] + cost[v];

                    if (newCost < cost[u]) {
                        cost[u] = newCost;
                        path[u] = v;
                    }
                }
            }
        }

        System.out.print("Shortest path: ");
        int current = source;

        while (current != -1) {
            System.out.print((current + 1));

            if (current == destination) {
                break;
            }

            System.out.print(" -> ");
            current = path[current];
        }

        System.out.println();
        return cost[source];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int source = 0;
        int destination = n - 1;

        int minimumCost = shortestPath(graph, n, source, destination);

        System.out.println("Minimum cost: " + minimumCost);

        sc.close();
    }
}