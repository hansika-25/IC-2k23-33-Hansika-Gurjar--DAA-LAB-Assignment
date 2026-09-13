# Iterative Binary Search

## Problem Statement

Implement Iterative Binary Search to find a given element in a sorted array.

## Algorithm / Approach

1. Set `low = 0` and `high = n - 1`.
2. Repeat while `low <= high`.
3. Calculate the middle index:
   `mid = low + (high - low) / 2`
4. If `arr[mid]` is equal to the search element, return `mid`.
5. If the search element is smaller than `arr[mid]`, search in the left half.
6. Otherwise, search in the right half.
7. If the element is not found, return `-1`.

## Pseudocode

```text
START

Input sorted array
Input search element

low = 0
high = n - 1

WHILE low <= high

    mid = low + (high - low) / 2

    IF arr[mid] == key
        Return mid
    ELSE IF key < arr[mid]
        high = mid - 1
    ELSE
        low = mid + 1

Return -1

END