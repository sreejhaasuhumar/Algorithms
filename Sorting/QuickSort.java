package Sorting;//Quicksort is a highly efficient sorting algorithm and is based on partitioning of array of data into smaller arrays.

/*
 * Quick Sort Algorithm
 * Quick Sort works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.
 */

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        // Mutates arr so that it is sorted via quick sort.
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

/* what will be the initial value of low and high when we call quickSort function
    * Initial call to quickSort should be with low = 0 and high = arr.length - 1
    so i=low-1 will be -1 why
    * This is because we want to start the partitioning process from the beginning of the array.
    When we increment i in the loop, it will first become 0, which is the index of the first element in the array.
    This way, when we swap arr[i] and arr[j], we are swapping the first element of the array with itself if it is less than or equal to the pivot.
    If we started with i = low, we would skip the first element in the partitioning process.
    * This ensures that all elements are considered during the partitioning.
 */

/*Logic 
 * 1. Choose a pivot element from the array (commonly the last element).
 * 2. Partition the array into two sub-arrays: elements less than or equal to the pivot and elements greater than the pivot.
 * 3. Recursively apply the same logic to the left and right sub-arrays.
 * * Time Complexity: O(n log n) on average, O(n^2) in the worst case (when the smallest or largest element is always chosen as the pivot).
 * * Space Complexity: O(log n) due to recursive stack space.
 */

 /* Features
  * 1. Efficient for large datasets.
  * 2. In-place sorting (requires only a small, constant amount of additional storage space).
  * 3. Not a stable sort (relative order of equal elements may change).
  * 4. Can be optimized with techniques like choosing a better pivot (e.g., median-of-three).
  * 5. Generally faster in practice compared to other O(n log n) algorithms like Merge Sort and Heap Sort due to better cache performance.
  * 6. Suitable for parallel processing.
  */