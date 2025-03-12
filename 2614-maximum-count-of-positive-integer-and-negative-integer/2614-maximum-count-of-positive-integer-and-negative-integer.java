class Solution {
    public int maximumCount(int[] nums) 
    {
        int res=0;
        int posNum=0;
        int negNum=0;


        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
               negNum++;
            }
            else if(nums[i]>0)
            {
                posNum++;
            }
        }
        if(posNum>negNum)
         return posNum;
        return negNum;
    }
}