
import java.util.*;

public class TSP {

    static int tsp(int[][] graph, int n) {
        int totalMasks = 1 << n;
        int[][] dp = new int[totalMasks][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        dp[1][0] = 0;

        for (int mask = 1; mask < totalMasks; mask++) {
            for (int u = 0; u < n; u++) {

                if ((mask & (1 << u)) == 0) {
                    continue;
                }

                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) == 0) {

                        int newMask = mask | (1 << v);

                        dp[newMask][v] = Math.min(
                            dp[newMask][v],
                            dp[mask][u] + graph[u][v]
                        );
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            answer = Math.min(
                answer,
                dp[totalMasks - 1][i] + graph[i][0]
            );
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Minimum travelling cost: " + tsp(graph, n));

        sc.close();
    }
}
