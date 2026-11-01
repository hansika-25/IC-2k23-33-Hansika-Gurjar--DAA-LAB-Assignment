import java.util.Scanner;

public class ShortestPath {

    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void bellmanFord(Edge[] edges, int vertices, int source) {
        int[] distance = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.destination]) {

                    distance[edge.destination] =
                        distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative weight cycle
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                distance[edge.source] + edge.weight < distance[edge.destination]) {

                System.out.println("Graph contains a negative weight cycle.");
                return;
            }
        }

        System.out.println("Shortest distances from source vertex " + (source + 1) + ":");

        for (int i = 0; i < vertices; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + (i + 1) + ": INF");
            } else {
                System.out.println("Vertex " + (i + 1) + ": " + distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edgeCount = sc.nextInt();

        Edge[] edges = new Edge[edgeCount];

        System.out.println("Enter edges (source destination weight):");

        for (int i = 0; i < edgeCount; i++) {
            int source = sc.nextInt() - 1;
            int destination = sc.nextInt() - 1;
            int weight = sc.nextInt();

            edges[i] = new Edge(source, destination, weight);
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt() - 1;

        bellmanFord(edges, vertices, source);

        sc.close();
    }
}