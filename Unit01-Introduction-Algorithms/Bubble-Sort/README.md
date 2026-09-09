# Bubble Sort

## 1. Problem Statement

Given an array of integers, sort the elements in ascending order
using the Bubble Sort algorithm.

The algorithm repeatedly compares adjacent elements and swaps them
if they are in the wrong order.

---

## 2. Algorithm / Approach

Bubble Sort is a comparison-based sorting algorithm.

The algorithm works as follows:

1. Start from the first element of the array.
2. Compare two adjacent elements.
3. If the first element is greater than the second element, swap them.
4. Continue comparing adjacent elements until the end of the array.
5. After one complete pass, the largest unsorted element reaches its correct position.
6. Repeat the process for the remaining unsorted elements.
7. If no swapping occurs during a pass, the array is already sorted and the algorithm stops.

---

## 3. Pseudocode

```text
BUBBLE_SORT(A)

n ← length(A)

FOR i ← 0 TO n - 2

    swapped ← false

    FOR j ← 0 TO n - i - 2

        IF A[j] > A[j + 1]

            Swap A[j] and A[j + 1]

            swapped ← true

        END IF

    END FOR

    IF swapped = false

        BREAK

    END IF

END FOR

END