class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int i=0;
        while(i<nums.length)
        {
            if(nums[i]==target)
            {
                return i;
            }
            else if(nums[i]>target)
             return i;
            else if(nums.length-1==i)
              return i+1;
            i++;
        }
        return 1;
    }
}