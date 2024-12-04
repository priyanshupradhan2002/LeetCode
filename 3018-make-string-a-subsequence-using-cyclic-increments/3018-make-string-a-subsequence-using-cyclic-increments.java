class Solution {
    public boolean canMakeSubsequence(String str1, String str2) 
    {
        int str2len=str2.length();
        int strInx=0;

        for(char currchar:str1.toCharArray())
        {
            if(strInx<str2len && (str2.charAt(strInx)- currchar +26)%26<=1)
            {
                strInx++;
            }
        }
        return strInx==str2len;
    }
}