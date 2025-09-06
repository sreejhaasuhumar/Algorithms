package Searching;/*
 * Given an integer array nums sorted in non-decreasing order, return the maximum of the count of positive numbers and the count of negative numbers in nums.
 * If there are no positive numbers, return 0. If there are no negative numbers, return 0.
 * Example 1:
 * Input: nums = [-2,-1,-1,1,2,3]
 * Output: 3
 */

class MaxCountOfPosAndNegNumbers {
    public int maximumCount(int[] nums) {
        int positiveCount = nums.length - upperBound(nums);
        int negativeCount = lowerBound(nums);
        return Math.max(positiveCount, negativeCount);
    }

    private int lowerBound(int nums[]) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < 0) {
                start = mid + 1;
            } else if (nums[mid] >= 0) {
                end = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    private int upperBound(int nums[]) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= 0) {
                start = mid + 1;
            } else if (nums[mid] > 0) {
                end = mid - 1;
                index = mid;
            }
        }
        return index;
    }
}

/*Logic:
 1. Initialize two variables, positiveCount and negativeCount, to count the number of positive and negative numbers in the array.
 2. Use binary search to find the index of the first positive number (upper bound) and the index of the first negative number (lower bound).
 3. Calculate the count of positive numbers as the difference between the length of the array and the index of the first positive number.
 4. Calculate the count of negative numbers as the index of the first negative number.
 5. Return the maximum of positiveCount and negativeCount.
 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

//why index is assigned in the else part of the condition in lowerBound and upperBound methods?
// The index is assigned in the else part of the condition in the lowerBound and upperBound methods to keep track of the position where the first negative or positive number is found. This allows us to return the correct index when there are no negative or positive numbers in the array, ensuring that we can accurately count the number of positive and negative numbers. If we find a number that meets the condition (negative for lowerBound, positive for upperBound), we update the index to that position, which will be used later to calculate the counts. If no such number is found, we return the length of the array, indicating that there are no such numbers.