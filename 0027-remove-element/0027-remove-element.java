class Solution {
    public int removeElement(int[] nums, int val) 
    {
       // Arrays.sort(nums);
       // char ch=nums.toCharArray();
         int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
            {
               nums[count]=nums[i];
               count++;
            }
        }
        return count;
    }
}