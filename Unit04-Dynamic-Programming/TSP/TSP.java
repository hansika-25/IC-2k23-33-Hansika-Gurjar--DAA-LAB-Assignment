import java.util.Scanner;

public class TSP {

    static int n;
    static int[][] cost;
    static int[][] dp;
    static final int INF = 999999;

    public static int tsp(int mask, int current) {

        // All cities visited: return to starting city
        if (mask == (1 << n) - 1) {
            return cost[current][0];
        }

        if (dp[mask][current] != -1) {
            return dp[mask][current];
        }

        int minimumCost = INF;

        for (int next = 0; next < n; next++) {

            // Visit only unvisited cities
            if ((mask & (1 << next)) == 0) {

                int newCost = cost[current][next]
                        + tsp(mask | (1 << next), next);

                minimumCost = Math.min(minimumCost, newCost);
            }
        }

        dp[mask][current] = minimumCost;
        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        cost = new int[n][n];

        System.out.println("Enter cost matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        dp = new int[1 << n][n];

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int minimumCost = tsp(1, 0);

        System.out.println("Minimum cost of Travelling Salesman Tour: " + minimumCost);

        sc.close();
    }
}