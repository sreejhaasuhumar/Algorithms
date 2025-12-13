import java.util.*;

/*
 * PROBLEM: Longest Consecutive Elements in an Unsorted Array
 *
 * Given an unsorted array of integers, find the length of the longest consecutive 
 * elements sequence. You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Its length is 4.
 *
 * Example 2:
 * Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
 * Output: 9
 * Explanation: The longest consecutive elements sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]. Its length is 9.
 *
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 *
 * FAANG Acceptance:
 * This problem is frequently asked in interviews at top tech companies including:
 * - Google (FAANG)
 * - Facebook/Meta (FAANG)
 * - Amazon (FAANG)
 * - Apple (FAANG)
 * - Netflix (FAANG)
 * - Microsoft
 * - LinkedIn
 * - Uber
 *
 * Difficulty: Medium
 * Topic: Arrays & Hashing (also HashSet)
 * Key insight: Use HashSet to mark visited numbers and find sequence boundaries in O(n) time.
 *
 * APPROACH:
 * 1. Convert array to a HashSet for O(1) lookups.
 * 2. For each number, check if it's the START of a sequence (num - 1 not in set).
 * 3. If it's a start, count the consecutive sequence length.
 * 4. Track the maximum length found.
 * Time Complexity: O(n) - Each number is visited at most twice (once in loop, once in while counting).
 * Space Complexity: O(n) - HashSet storage.
 */

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Convert array to HashSet for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // Only start counting from the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // Test cases
    public static void main(String[] args) {
        // Test 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + longestConsecutive(nums1)); // Output: 4 (sequence: 1,2,3,4)

        // Test 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + longestConsecutive(nums2)); // Output: 9 (sequence: 0-8)

        // Test 3 - Empty array
        int[] nums3 = {};
        System.out.println("Test 3: " + longestConsecutive(nums3)); // Output: 0

        // Test 4 - Single element
        int[] nums4 = {5};
        System.out.println("Test 4: " + longestConsecutive(nums4)); // Output: 1

        // Test 5 - Duplicates
        int[] nums5 = {1, 2, 0, 1};
        System.out.println("Test 5: " + longestConsecutive(nums5)); // Output: 3 (sequence: 0,1,2)

        // Test 6 - Negative numbers
        int[] nums6 = {-7, -1, 3, -9, 2, -8, 0, 4, 8, 6, -5, -4, -6, 7};
        System.out.println("Test 6: " + longestConsecutive(nums6)); // Output: 4 (sequence: 3,4,6,7 or 0,2)
    }
}
