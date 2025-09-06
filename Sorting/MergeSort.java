package Sorting;/*
 * Merge Sort Algorithm
 * This code implements the Merge Sort algorithm, which sorts an array of integers in ascending order.
 * Merge Sort works by recursively dividing the array into two halves, sorting each half, and then merging the sorted halves back together.
 */

public class MergeSort {
    public void mergeSort(int[] arr) {
        // Mutates arr so that it is sorted via merge sort.
        if (arr.length < 2) {
            return; // Base case: arrays with 0 or 1 element are already sorted
        }
        int mid = arr.length / 2;

        // Split the array into two halves
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves back together
        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two arrays while there are elements in both
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy any remaining elements from the right array
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

/* Logic:
 * 1. If the array has 0 or 1 element, it is already sorted (base case).
 * 2. Divide the array into two halves.
 * 3. Recursively apply merge sort to both halves.
 * 4. Merge the two sorted halves back together into a single sorted array.
 * * Time Complexity: O(n log n) in all cases (best, average, worst).
 * * Space Complexity: O(n) due to the temporary arrays used for merging.   
 */

 /* Features
  * 1. Efficient for large datasets due to its O(n log n) time complexity.
    * 2. Stable sort (does not change the relative order of equal elements).
    * 3. Requires additional memory for temporary arrays, which can be a drawback for very large datasets.
    * 4. Performs well on linked lists and large datasets that do not fit into memory.
    * 5. Not an in-place sorting algorithm due to the use of temporary arrays.
    * 6. Suitable for parallel processing as the two halves can be sorted independently.
  */