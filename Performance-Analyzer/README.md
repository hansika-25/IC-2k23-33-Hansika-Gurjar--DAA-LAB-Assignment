# Algorithm Performance Analyzer

## Problem Statement

Develop an Algorithm Performance Analyzer to compare the theoretical and experimental performance of different sorting algorithms.

The analyzer measures the execution time of sorting algorithms for different input sizes and stores the experimental results in a CSV file.

## Algorithms Analyzed

The following sorting algorithms are analyzed:

1. Bubble Sort
2. Insertion Sort
3. Selection Sort
4. Merge Sort
5. Quick Sort

## Approach

1. Generate random input arrays of different sizes.
2. Create a copy of the input array for each algorithm.
3. Execute each sorting algorithm on the same input data.
4. Measure the execution time using `System.nanoTime()`.
5. Store the execution time along with the algorithm name and input size.
6. Save the experimental results in `performance-results.csv`.
7. Use the collected data to generate performance graphs.

## Input Sizes

The analyzer currently uses:

```text
100
500
1000
2000
5000