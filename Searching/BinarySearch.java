package Searching;

class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

/*Logic:
 * 1.Initialize left and right parameters as 0 and n.
 * 2.While left is less than or equal to right, calculate the mid index.
 * 3.If the mid element is equal to the target, return mid.
 * 4.If the mid element is greater than the target, move the right pointer to mid - 1.
 * 5.If the mid element is less than the target, move the left pointer to mid + 1.
 * 6.If the target is not found, return -1.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */