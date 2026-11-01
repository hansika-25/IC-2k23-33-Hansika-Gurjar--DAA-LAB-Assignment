import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class KruskalsAlgorithm {

    static int findParent(int[] parent, int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }

        return parent[vertex] = findParent(parent, parent[vertex]);
    }

    static void union(int[] parent, int[] rank, int u, int v) {
        int rootU = findParent(parent, u);
        int rootV = findParent(parent, v);

        if (rootU == rootV) {
            return;
        }

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    public static void kruskal(Edge[] edges, int vertices) {
        Arrays.sort(edges);

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int totalWeight = 0;
        int edgesSelected = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        for (Edge edge : edges) {
            int rootU = findParent(parent, edge.source);
            int rootV = findParent(parent, edge.destination);

            if (rootU != rootV) {
                System.out.println(edge.source + " - " +
                        edge.destination + " : " + edge.weight);

                union(parent, rank, edge.source, edge.destination);

                totalWeight += edge.weight;
                edgesSelected++;

                if (edgesSelected == vertices - 1) {
                    break;
                }
            }
        }

        if (edgesSelected != vertices - 1) {
            System.out.println("Graph is disconnected. MST cannot be formed.");
        } else {
            System.out.println("Total MST Weight: " + totalWeight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edgeCount = sc.nextInt();

        Edge[] edges = new Edge[edgeCount];

        System.out.println("Enter source, destination, and weight for each edge:");

        for (int i = 0; i < edgeCount; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            edges[i] = new Edge(source, destination, weight);
        }

        kruskal(edges, vertices);

        sc.close();
    }
}