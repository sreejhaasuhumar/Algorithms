/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int val = target - nums[i];
            if(map.containsKey(val))
            {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i],i);
        }

        return new int[]{0,0};

    }
}

/* Logic:
 * 1. Initialize a HashMap to store the numbers and their indices.
 * 2. Iterate through the array, for each number, calculate the complement (target - current number).
 * 3. Check if the complement exists in the HashMap.
 * 4. If it exists, return the indices of the current number and its complement.
 * 5. If it does not exist, add the current number and its index to the HashMap.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

