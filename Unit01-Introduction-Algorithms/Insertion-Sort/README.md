# Insertion Sort

## 1. Problem Statement

Given an array of integers, sort the elements in ascending order
using the Insertion Sort algorithm.

---

## 2. Algorithm / Approach

Insertion Sort builds the sorted array one element at a time.

The first element is considered sorted. The next element is selected
as the key and compared with the elements before it.

Elements greater than the key are shifted one position to the right.
The key is then inserted into its correct position.

This process is repeated until all elements are sorted.

---

## 3. Pseudocode

```text
INSERTION_SORT(A)

n ← length(A)

FOR i ← 1 TO n - 1

    key ← A[i]

    j ← i - 1

    WHILE j >= 0 AND A[j] > key

        A[j + 1] ← A[j]

        j ← j - 1

    END WHILE

    A[j + 1] ← key

END FOR

END