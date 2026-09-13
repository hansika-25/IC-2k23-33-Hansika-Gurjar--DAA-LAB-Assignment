import java.util.Scanner;

public class RecursiveBubbleSort {

    // Recursive method to perform Bubble Sort
    public static void recursiveBubbleSort(int[] arr, int n) {

        // Base case
        if (n <= 1) {
            return;
        }

        boolean swapped = false;

        // Perform one pass and move the largest element to the end
        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > arr[i + 1]) {

                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                swapped = true;
            }
        }

        // If no swapping occurred, array is already sorted
        if (!swapped) {
            return;
        }

        // Recursively sort the remaining array
        recursiveBubbleSort(arr, n - 1);
    }

    // Method to print the array
    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array:");
        printArray(arr);

        // Apply Recursive Bubble Sort
        recursiveBubbleSort(arr, n);

        System.out.println("Sorted Array:");
        printArray(arr);

        sc.close();
    }
}