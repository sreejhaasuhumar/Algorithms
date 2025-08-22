public class Main {
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