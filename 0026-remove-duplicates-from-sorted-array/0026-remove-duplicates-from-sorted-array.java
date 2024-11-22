class Solution {
    public int removeDuplicates(int[] nums) 
    {
        HashMap<Integer, Boolean> map=new HashMap<>();
               int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!(map.containsKey(nums[i])))
            {
                  map.put(nums[i], true);  // Mark as visited
                nums[count] = nums[i];        // Place it in the array
                count++;
            }
                 
            

        }

        return count;
    }
}