class Solution {
    public List<String> stringMatching(String[] words) 
    {
        Set<String> s=new HashSet<>();
        ArrayList<String> al=new ArrayList<>();

        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words.length;j++)
            {
                if(i!=j && words[i].length()>words[j].length())
                {
                    if(words[i].contains(words[j]))
                      s.add(words[j]);
                }
            }
        }
        for(String st:s)
        {
            al.add(st);
        }
        return al;
    }
}