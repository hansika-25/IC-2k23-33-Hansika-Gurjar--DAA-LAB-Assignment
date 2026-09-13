# Recursive Bubble Sort

## 1. Problem Statement

Implement Bubble Sort using recursion to arrange a given array of elements in ascending order.

## 2. Algorithm / Approach

1. Compare adjacent elements in the array.
2. Swap them if they are in the wrong order.
3. After one complete pass, the largest element reaches the end.
4. Recursively apply Bubble Sort to the remaining unsorted portion.
5. Stop when the size of the remaining array becomes 1 or when no swapping occurs.

## 3. Pseudocode

RecursiveBubbleSort(A, n)

1. If n <= 1
       Return

2. swapped = false

3. For i = 0 to n-2
       If A[i] > A[i+1]
           Swap A[i] and A[i+1]
           swapped = true

4. If swapped == false
       Return

5. RecursiveBubbleSort(A, n-1)

## 4. Flowchart

The Recursive Bubble Sort flowchart has been created using Draw.io and is available at:

`docs/algorithm-flowcharts/Recursive-Bubble-Sort.drawio`

## 5. Time & Space Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | O(n) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

Space Complexity: O(n) due to recursive function calls.

## 6. Sample Input / Output

### Input

```text
5
8 3 15 6 2