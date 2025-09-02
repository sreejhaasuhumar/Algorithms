public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while(left<right) {
            if(leftMax<rightMax) {
                left++;
                leftMax = Math.max(leftMax,height[left]);
                water = water + (leftMax-height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax,height[right]);
                water = water + (rightMax-height[right]);

            }
        }
        return water;  
    }
}

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
*/
