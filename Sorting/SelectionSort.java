/*
 * Selection Sort Algorithm
 * This code implements the Selection Sort algorithm, which sorts an array of integers in ascending order. 
 * Selection Sort works by repeatedly finding the minimum element from the unsorted part of the array and swapping it with the first unsorted element.
 */

public class SelectionSort {
    public void selectionSort(int[] arr) {
        // Mutates arr so that it is sorted via selection sort.
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

/* Logic:
 * 1. Iterate through the array with an index `i` from 0 to n-1.
 * 2. For each `i`, assume the minimum element is at index `i` and store it in `minIndex`.
 * 3. Iterate through the remaining unsorted elements (from `i+1` to n) to find the actual minimum element.
 * 4. If a smaller element is found, update `minIndex`.
 * 5. After finding the minimum element, swap it with the first unsorted element at index `i`.
 * 6. Repeat the process until the entire array is sorted.
 * Time Complexity: O(n^2) in the worst case.
 * Space Complexity: O(1) as it sorts the array in place.
 */

/* Features
    * 1. Simple and easy to implement.
    * 2. Does not require additional memory for sorting.
    * 3. Not a stable sort (relative order of equal elements may change).
    * 4. Performs well on small datasets or nearly sorted arrays.
    * 5. Inefficient on large datasets due to O(n^2) time complexity.
    */