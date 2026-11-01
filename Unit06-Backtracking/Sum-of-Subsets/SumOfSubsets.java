import java.util.*;

public class SumOfSubsets {
    static int[] weights;
    static int n;
    static int target;
    static int solutionCount = 0;

    static void sumOfSubsets(int index, int currentSum, List<Integer> subset) {
        if (currentSum == target) {
            solutionCount++;
            System.out.println("Subset " + solutionCount + ": " + subset);
            return;
        }

        if (index == n || currentSum > target) {
            return;
        }

        // Include the current element
        subset.add(weights[index]);
        sumOfSubsets(index + 1, currentSum + weights[index], subset);

        // Backtrack: remove the current element
        subset.remove(subset.size() - 1);

        // Exclude the current element
        sumOfSubsets(index + 1, currentSum, subset);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        weights = new int[n];

        System.out.println("Enter positive elements:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        target = sc.nextInt();

        System.out.println("Subsets with sum " + target + ":");
        sumOfSubsets(0, 0, new ArrayList<>());

        if (solutionCount == 0) {
            System.out.println("No subset found.");
        }

        sc.close();
    }
}
