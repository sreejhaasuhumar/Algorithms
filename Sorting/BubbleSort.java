/*
 * Bubble Sort Implementation in Java
 * This code implements the Bubble Sort algorithm, which sorts an array of integers in ascending order.
 * * Bubble Sort works by repeatedly stepping through the list, comparing adjacent elements and swapping them if they are in the wrong order.
 * * The pass through the list is repeated until the list is sorted.
*/

 public class Solution {
    public void bubbleSort(int[] arr) {
        // Mutates arr so that it is sorted via swapping adjacent elements until
        // the arr is sorted.
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap adjacent elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }
}

/* Logic:
 * 1. Initialize a boolean variable `hasSwapped` to true to enter the while loop.
 * 2. In the while loop, set `hasSwapped` to false at the beginning of each iteration.
 * 3. Iterate through the array using a for loop, comparing adjacent elements.
 * 4. If the current element is greater than the next element, swap them and set `hasSwapped` to true.
 * 5. Repeat the process until no swaps are made in a complete pass through the array, indicating that the array is sorted.
 * Time Complexity: O(n^2) in the worst case, O(n) in the best case (when the array is already sorted).
 * Space Complexity: O(1) as it sorts the array in place.
 */

 /* Features
  * 1. Simple and easy to understand.
    * 2. Does not require additional memory for sorting.
    * 3. Stable sort (does not change the relative order of equal elements).
    * 4. Can be optimized to stop early if the array is already sorted.
    * 5. Suitable for small datasets or nearly sorted arrays.
    * 6. Not suitable for large datasets due to its O(n^2) time complexity.
  */