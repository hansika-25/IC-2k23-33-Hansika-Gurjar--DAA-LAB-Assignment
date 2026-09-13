# Recursive Insertion Sort

## 1. Problem Statement

Implement Insertion Sort using recursion to arrange a given array of elements in ascending order.

## 2. Algorithm / Approach

1. Recursively sort the first `n-1` elements.
2. Take the last element as the key.
3. Compare the key with the sorted elements.
4. Shift elements greater than the key one position ahead.
5. Insert the key into its correct position.
6. Repeat until the entire array is sorted.

## 3. Pseudocode

RecursiveInsertionSort(A, n)

1. If n <= 1
       Return

2. RecursiveInsertionSort(A, n-1)

3. key = A[n-1]
4. j = n-2

5. While j >= 0 AND A[j] > key
       A[j+1] = A[j]
       j = j-1

6. A[j+1] = key

## 4. Flowchart

The Recursive Insertion Sort flowchart has been created using Draw.io and is available at:

`docs/algorithm-flowcharts/Recursive-Insertion-Sort.drawio`

## 5. Time & Space Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

Space Complexity: O(n) due to recursive function calls.

## 6. Sample Input / Output

### Input

```text
5
8 3 15 6 2