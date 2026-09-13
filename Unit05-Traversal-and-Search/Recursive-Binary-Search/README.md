# Recursive Binary Search

## Problem Statement

Implement Recursive Binary Search to find a given element in a sorted array.

## Algorithm / Approach

1. Set `low = 0` and `high = n - 1`.
2. Calculate the middle index.
3. If `low > high`, the element is not present.
4. If `arr[mid]` is equal to the search element, return the middle index.
5. If the search element is smaller than `arr[mid]`, recursively search the left half.
6. Otherwise, recursively search the right half.
7. Continue until the element is found or the search range becomes empty.

## Pseudocode

```text
START

Input sorted array
Input search element

Call binarySearch(low, high)

IF low > high
    Return -1

mid = low + (high - low) / 2

IF arr[mid] == key
    Return mid

IF key < arr[mid]
    Search left half recursively
ELSE
    Search right half recursively

END