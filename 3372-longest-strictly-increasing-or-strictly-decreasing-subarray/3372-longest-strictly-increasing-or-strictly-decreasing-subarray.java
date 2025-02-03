class Solution {
    public int longestMonotonicSubarray(int[] nums) 
    {
        int increasing=1;
        int decreasing=1;
        // int length_decrease=0;
        // int length_increase=0;
        int length=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                
                increasing++;
               if(increasing>length)
               {
                length=increasing;
               }
                //length_decrease=0;
                decreasing=1;
               
            }
            else if(nums[i]>nums[i+1])
            {
               decreasing++;
               if(decreasing>length)
               {
                length=decreasing;
               }
              // length_increase=0;
               increasing=1;
            }
            else
            {
increasing=1;
         decreasing=1;
        //length_decrease=0;
        //length_increase=0;
            }
        }
        // if(length_decrease<length_increase)
        // return length_increase;
        // else if(length_increase<length_decrease)
        //  return length_decrease;
        if(length==0)
         return 1;
        return length;
    }
}