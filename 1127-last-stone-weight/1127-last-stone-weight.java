class Solution {
    public int lastStoneWeight(int[] stones) 
    {
       if(stones.length==1)
        return stones.length; 
        ArrayList<Integer> ls=new ArrayList<>();
        int x=0;
        for(int i:stones)
        {
            ls.add(i);
        }
        int n=ls.size();
        while((n-1)!=0)
        {
            Collections.sort(ls);
             x=ls.get(n-1)-ls.get(n-2);
            ls.remove(ls.get(n-1));
            ls.remove(ls.get(n-2));
            ls.add(x);
            n--;

        }
        return x;
    }
}