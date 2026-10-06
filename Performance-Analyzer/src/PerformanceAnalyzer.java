import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class PerformanceAnalyzer {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

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

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {

        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }

    // Measure execution time
    public static long measureTime(String algorithm, int[] originalArray) {

        int[] arr = Arrays.copyOf(originalArray, originalArray.length);

        long startTime = System.nanoTime();

        switch (algorithm) {

            case "Bubble Sort":
                bubbleSort(arr);
                break;

            case "Insertion Sort":
                insertionSort(arr);
                break;

            case "Selection Sort":
                selectionSort(arr);
                break;

            case "Merge Sort":
                mergeSort(arr, 0, arr.length - 1);
                break;

            case "Quick Sort":
                quickSort(arr, 0, arr.length - 1);
                break;

            default:
                throw new IllegalArgumentException("Unknown algorithm");
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static void main(String[] args) {

        int[] inputSizes = {100, 500, 1000, 2000, 5000};

        String[] algorithms = {
                "Bubble Sort",
                "Insertion Sort",
                "Selection Sort",
                "Merge Sort",
                "Quick Sort"
        };

        try {

            FileWriter writer = new FileWriter(
                    "../performance-results.csv"
            );

            writer.write("Algorithm,Input Size,Execution Time (ns)\n");

            System.out.println("Algorithm Performance Analyzer");
            System.out.println("--------------------------------");

            for (int size : inputSizes) {

                int[] data = generateRandomArray(size);

                System.out.println("\nInput Size: " + size);

                for (String algorithm : algorithms) {

                    long time = measureTime(algorithm, data);

                    System.out.println(
                            algorithm + " : " + time + " ns"
                    );

                    writer.write(
                            algorithm + "," +
                            size + "," +
                            time + "\n"
                    );
                }
            }

            writer.close();

            System.out.println("\nPerformance results saved to:");
            System.out.println("performance-results.csv");

        } catch (IOException e) {

            System.out.println(
                    "Error writing performance results: "
                            + e.getMessage()
            );
        }
    }
}