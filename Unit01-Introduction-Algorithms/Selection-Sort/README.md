# Selection Sort

## 1. Problem Statement

Implement Selection Sort to arrange a given array of elements in ascending order.

## 2. Algorithm / Approach

1. Start from the first element of the array.
2. Assume it is the minimum element.
3. Search the remaining unsorted part of the array.
4. Find the smallest element.
5. Swap it with the first element of the unsorted part.
6. Repeat the process until the array is sorted.

## 3. Pseudocode

SelectionSort(A, n)

1. For i = 0 to n-2
2.     minIndex = i
3.     For j = i+1 to n-1
4.         If A[j] < A[minIndex]
5.             minIndex = j
6.     Swap A[i] and A[minIndex]
7. End

## 4. Flowchart

The Selection Sort flowchart has been created using Draw.io and will be available at:

`docs/algorithm-flowcharts/Selection-Sort.drawio`

## 5. Time & Space Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

Space Complexity: O(1)

Selection Sort performs approximately the same number of comparisons regardless of the initial order of the array.

## 6. Sample Input / Output

### Input

```text
5
8 3 15 6 2