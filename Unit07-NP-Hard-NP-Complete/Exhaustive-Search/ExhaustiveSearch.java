
import java.util.*;

public class ExhaustiveSearch {

    static void findSubsets(int[] arr, int target) {
        int n = arr.length;
        boolean found = false;

        // Generate all possible subsets
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    subset.add(arr[i]);
                }
            }

            if (sum == target) {
                System.out.println(subset);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No subset found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("Subsets with sum " + target + ":");
        findSubsets(arr, target);

        sc.close();
    }
}
