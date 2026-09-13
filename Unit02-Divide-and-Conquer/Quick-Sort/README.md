# Quick Sort

## 1. Problem Statement

Implement Quick Sort using the Divide-and-Conquer technique to arrange a given array of elements in ascending order.

## 2. Algorithm / Approach

1. Select an element as the pivot.
2. Partition the array around the pivot.
3. Place elements smaller than the pivot on its left.
4. Place elements greater than the pivot on its right.
5. Recursively apply Quick Sort to the left and right parts.
6. Continue until the subarray contains zero or one element.

## 3. Pseudocode

QuickSort(A, low, high)

1. If low < high
2.     pivotIndex = Partition(A, low, high)
3.     QuickSort(A, low, pivotIndex - 1)
4.     QuickSort(A, pivotIndex + 1, high)

Partition(A, low, high)

1. pivot = A[high]
2. i = low - 1
3. For j = low to high - 1
4.     If A[j] < pivot
5.         i = i + 1
6.         Swap A[i] and A[j]
7. Swap A[i+1] and A[high]
8. Return i+1

## 4. Flowchart

The Quick Sort flowchart has been created using Draw.io and is available at:

`docs/algorithm-flowcharts/Quick-Sort.drawio`

## 5. Time & Space Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n²) |

Space Complexity:

- Average Case: O(log n)
- Worst Case: O(n)

The space is mainly used by recursive function calls.

## 6. Sample Input / Output

### Input

```text
5
8 3 15 6 2