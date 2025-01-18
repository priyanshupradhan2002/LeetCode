class Solution {
    public int majorityElement(int[] nums) 
    {
        Arrays.sort(nums);
        int n=0;
        for(int i=0;i<nums.length;i++)
        {
            n++;
        }
        return nums[n/2];
    }
}