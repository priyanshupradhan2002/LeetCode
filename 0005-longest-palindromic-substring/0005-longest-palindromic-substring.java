class Solution {
    public String longestPalindrome(String s) 
    {
        int st=0;int end=0;
        for(int i=0;i<s.length();i++)
        {
            int len1=expandFromCenter(s,i,i+1);
            int len2=expandFromCenter(s,i,i);

             int len=Math.max(len1,len2);

             if(end-st<len)
             {
                st=i-(len-1)/2;
                end=i+len/2;
             }
        }
        return s.substring(st,end+1);
    }
    static int expandFromCenter(String s, int i, int j)
    {
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return j-i-1;
    }
}