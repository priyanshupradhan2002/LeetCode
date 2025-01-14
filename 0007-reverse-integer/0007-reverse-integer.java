class Solution {
    public int reverse(int x) 
    {
        long reverse=0;
        long duplicate=x;
        // if(x<0)
        //  x=-1*x;
        while(x!=0)
        {
            long num=x%10;
            reverse=reverse*10+num;
            x=x/10;
        }
        if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE)
         return 0;
        return (int)reverse;
    }
}