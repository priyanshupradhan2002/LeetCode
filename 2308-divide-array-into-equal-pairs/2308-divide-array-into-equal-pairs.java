class Solution {
    public boolean divideArray(int[] nums) 
    {
        HashSet<Integer> set=new HashSet<>();

        for(int i:nums)
        {
            if(!set.contains(i))
            {
                set.add(i);
            }
            else
            {
                set.remove(i);
            }
        }
        return set.isEmpty();
    }
}