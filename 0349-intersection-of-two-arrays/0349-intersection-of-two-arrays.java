class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        Set<Integer> set1=new HashSet<>();
        //Set<Integer> set2=new HashSet<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i:nums1)
        {
            if(!set1.contains(i))
            {
                set1.add(i);
            }
        }
        // int[] res=new int[set1.size()];
         int count=0;
         for(int i:nums2)
         {
            if(set1.contains(i) &&  !al.contains(i))
            {
             al.add(i);
            }
            
         }
          int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
         
       return res;
    }
}