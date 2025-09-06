package Sorting;/*
 * Insertion Sort Algorithm
 * This code implements the Insertion Sort algorithm, which sorts an array of integers in ascending order.
 * Insertion Sort works by building a sorted array one element at a time, by repeatedly taking the next element and inserting it into the correct position in the already sorted part of the array.
 */

public class InsertionSort {
    public void insertionSort(int[] arr) {
        // Mutates arr so that it is sorted via insertion sort.
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

/* Logic:
 * 1. Start from the second element (index 1) and iterate through the array.
 * 2. For each element (key), compare it with the elements in the sorted part of the array (to its left).
 * 3. Shift elements that are greater than the key to the right to make space for the key.
 * 4. Insert the key into its correct position in the sorted part of the array.
 * 5. Repeat the process until the entire array is sorted.
 * * Time Complexity: O(n^2) in the worst case, O(n) in the best case (when the array is already sorted).
 * * Space Complexity: O(1) as it sorts the array in place.
 */