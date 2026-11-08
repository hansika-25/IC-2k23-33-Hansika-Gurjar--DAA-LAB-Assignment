
import java.util.*;

public class KnapsackBranchBound {

    static class Item {
        int weight, profit;
        double ratio;

        Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
            this.ratio = (double) profit / weight;
        }
    }

    static class Node {
        int level, profit, weight;
        double bound;

        Node(int level, int profit, int weight) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
        }
    }

    static double calculateBound(Node node, int n,
                                 int capacity, Item[] items) {
        if (node.weight >= capacity) {
            return node.weight == capacity ? node.profit : 0;
        }

        double bound = node.profit;
        int totalWeight = node.weight;
        int j = node.level + 1;

        while (j < n && totalWeight + items[j].weight <= capacity) {
            totalWeight += items[j].weight;
            bound += items[j].profit;
            j++;
        }

        if (j < n) {
            bound += (capacity - totalWeight) * items[j].ratio;
        }

        return bound;
    }

    static int solveKnapsack(Item[] items, int capacity) {
        int n = items.length;

        Arrays.sort(items,
            (a, b) -> Double.compare(b.ratio, a.ratio));

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.bound, a.bound)
        );

        Node root = new Node(-1, 0, 0);
        root.bound = calculateBound(root, n, capacity, items);
        pq.add(root);

        int maxProfit = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.bound <= maxProfit ||
                current.level == n - 1) {
                continue;
            }

            int next = current.level + 1;

            // Include the next item
            Node include = new Node(
                next,
                current.profit + items[next].profit,
                current.weight + items[next].weight
            );

            if (include.weight <= capacity) {
                maxProfit = Math.max(maxProfit, include.profit);

                include.bound = calculateBound(
                    include, n, capacity, items
                );

                if (include.bound > maxProfit) {
                    pq.add(include);
                }
            }

            // Exclude the next item
            Node exclude = new Node(
                next, current.profit, current.weight
            );

            exclude.bound = calculateBound(
                exclude, n, capacity, items
            );

            if (exclude.bound > maxProfit) {
                pq.add(exclude);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and profit of each item:");
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int profit = sc.nextInt();
            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int result = solveKnapsack(items, capacity);

        System.out.println("Maximum profit: " + result);

        sc.close();
    }
}
