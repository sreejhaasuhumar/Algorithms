package SlidingWindow;/*
 * Problem: Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 */

class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0, sum=0, res= Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++) {
            sum = sum+nums[right];
            while(sum>=target) {
                res = Math.min(res, right-left+1);
                sum = sum-nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}

/* Logic:
    * 1. Initialize two pointers, left and right, to represent the start and end of the sliding window.
    * 2. Initialize a variable sum to keep track of the sum of the current window and res to store the minimum length.
    * 3. Iterate through the array with the right pointer, adding the current element to sum.
    * 4. While the sum is greater than or equal to the target, update res with the minimum length of the current window and move the left pointer to reduce the window size.
    * 5. Return res if it is not updated, otherwise return 0.
    * Time Complexity: O(n), where n is the length of the input array.
    * Space Complexity: O(1), as we are using only a constant amount of extra space.
 */