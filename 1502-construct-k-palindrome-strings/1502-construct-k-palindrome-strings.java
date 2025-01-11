class Solution {
    public boolean canConstruct(String s, int k) 
    {
        if(s.length()<k)
         return false;
        int n=s.length();
        int odd=0;

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i:map.values())
        {
            if(i%2!=0)
            {
                odd++;
            }
        }
        return odd<=k;
    }
}