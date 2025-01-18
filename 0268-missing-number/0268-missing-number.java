class Solution {
    public int missingNumber(int[] nums) 
    {
        int sum=0;
        int arr_sum=0;

        for(int i=1;i<=nums.length;i++)
        {
            sum+=i;
            arr_sum+=nums[i-1];
        }
        return sum-arr_sum;
    }
}