# Linear Search

## 1. Problem Statement

Implement Linear Search to find a given element in an array.

## 2. Algorithm / Approach

1. Start from the first element of the array.
2. Compare each element with the target element.
3. If the element matches the target, return its index.
4. Continue searching until the element is found or the array ends.
5. If the element is not found, return -1.

## 3. Pseudocode

LinearSearch(A, key)

1. For i = 0 to n-1
2.     If A[i] == key
3.         Return i
4. Return -1

## 4. Flowchart

The Linear Search flowchart has been created using Draw.io and is available at:

`docs/algorithm-flowcharts/Linear-Search.drawio`

## 5. Time & Space Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

Space Complexity: O(1)

Linear Search does not require the array to be sorted.

## 6. Sample Input / Output

### Input

```text
5
10 25 30 45 60
30