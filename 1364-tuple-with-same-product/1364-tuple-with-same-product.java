//import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) 
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int val=nums[i]*nums[j];
                map.put(val, map.getOrDefault(val,0)+1);
            }
        }
         int ans=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int key=entry.getKey();
            int value=entry.getValue();

            ans=ans+((value*(value-1))/2)*8;
        }
       return ans;
    }
}