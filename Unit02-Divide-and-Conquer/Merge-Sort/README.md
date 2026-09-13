# Merge Sort

## 1. Problem Statement

Implement Merge Sort using the Divide-and-Conquer technique to arrange a given array of elements in ascending order.

## 2. Algorithm / Approach

1. Divide the array into two halves.
2. Recursively sort the left half.
3. Recursively sort the right half.
4. Merge the two sorted halves.
5. Continue until the complete array is sorted.

## 3. Pseudocode

MergeSort(A, left, right)

1. If left < right
2.     middle = left + (right - left) / 2
3.     MergeSort(A, left, middle)
4.     MergeSort(A, middle + 1, right)
5.     Merge(A, left, middle, right)

Merge(A, left, middle, right)

1. Create temporary left and right arrays
2. Compare elements of both arrays
3. Place the smaller element into the original array
4. Copy remaining elements
5. End

## 4. Flowchart

The Merge Sort flowchart has been created using Draw.io and is available at:

`docs/algorithm-flowcharts/Merge-Sort.drawio`

## 5. Time & Space Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n log n) |

Space Complexity: O(n)

## 6. Sample Input / Output

### Input

```text
5
8 3 15 6 2