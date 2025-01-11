class Solution {
    public String longestPalindrome(String s) 
    {
        if(s.length()<=1)
         return s;
        
        String lps="";
        for(int i=1;i<s.length();i++)
        {
           //For odd Number
           int low=i;
           int high=i;

           while(s.charAt(low)==s.charAt(high))
           {
            low--;
            high++;
            if(low==-1 || high==s.length())
             break;
           }
           String pallindrome=s.substring(low+1,high);
           if(pallindrome.length()>lps.length())
           {
            lps=pallindrome;
           }

           //For even number
           low=i-1;
           high=i;
           while(s.charAt(low)==s.charAt(high))
           {
            low--;
            high++;

            if(low==-1 || high==s.length())
            break;
           }
           pallindrome=s.substring(low+1, high);
           if(pallindrome.length()>lps.length())
           {
            lps=pallindrome;
           }
        }
        return lps;
    }
}