import java.util.Arrays;
import java.util.Scanner;

public class MemoizedFibonacci {

    static int[] memo;

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            memo = new int[n + 1];
            Arrays.fill(memo, -1);

            int result = fibonacci(n);

            System.out.println("Fibonacci number at position " + n + ": " + result);
        }

        sc.close();
    }
}