class Solution {
    public int findDuplicate(int[] nums) 
    {
        // HashSet<Integer> s=new HashSet<Integer>();
        // //int res=0;

        // for(int num:nums)
        // {
        //     if(!s.contains(num))
        //     {
        //         s.add(num);
        //     }
        //     else
        //     {
        //         return num;
        //     }
        // }
        // return -1;

        boolean[] bol=new boolean[nums.length];
        for(int i:nums)
        {
            if(bol[i])
             return i;
            bol[i]=true;
        }
        return -1;
    }
}