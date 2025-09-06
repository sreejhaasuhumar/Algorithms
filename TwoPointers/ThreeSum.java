package TwoPointers;/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> list=threeSum(nums);
		System.out.println(list);

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);
	}

}

/* Logic:
 * 1. Sort the input array to handle duplicates and facilitate the two-pointer technique.
 * 2. Iterate through the array with an index i, treating nums[i] as the first element of the triplet.
 * 3. For each i, use two pointers j and k to find pairs that sum to -nums[i].
 * 4. If a valid triplet is found, add it to the result set to avoid duplicates.
 * 5. Adjust the pointers based on the sum of the triplet.
 * 6. Return the result as a list of lists.
 * Time Complexity: O(n^2), where n is the length of the input array.
 * Space Complexity: O(n) for storing the result set.
 */

 // To use two pointers , the array should be sorted.
// The two pointers technique is used to find pairs that sum to a specific value, in this case, -nums[i].
// The two pointers technique is typically used to find pairs or triplets that meet a specific condition, such as summing to a target value.
