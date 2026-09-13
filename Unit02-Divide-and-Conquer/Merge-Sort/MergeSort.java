
import java.util.Scanner;

public class MergeSort {

    // Method to merge two sorted parts
    public static void merge(int[] arr, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge the temporary arrays
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left array
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Recursive Merge Sort method
    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int middle = left + (right - left) / 2;

            // Sort left half
            mergeSort(arr, left, middle);

            // Sort right half
            mergeSort(arr, middle + 1, right);

            // Merge both halves
            merge(arr, left, middle, right);
        }
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

        // Apply Merge Sort
        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");
        printArray(arr);

        sc.close();
    }
}