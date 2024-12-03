class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int sum=0;
        int result=Integer.MAX_VALUE;

        for(int i=0;i<nums.length-2;i++)
        {
            int j=i+1;
            int k=nums.length-1;
           while(j<k)
           {
              sum=nums[i]+nums[j]+nums[k];


               if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                // Adjust pointers based on the sum
                if (sum < target) {
                    j++; // If sum is smaller than target, increase left pointer
                } else if (sum > target) {
                    k--; // If sum is greater than target, decrease right pointer
                } else {
                    return sum; // If we find the exact target, return it immediately
                }
            }
           
        }
        return result;
    }
}