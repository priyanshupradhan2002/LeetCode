class Solution {
    public boolean isPalindrome(String s) 
    {
        s=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        s=s.replaceAll(" ","");

        int i=0;
        int j=s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        //System.out.println(s);
        return true;
    }
}