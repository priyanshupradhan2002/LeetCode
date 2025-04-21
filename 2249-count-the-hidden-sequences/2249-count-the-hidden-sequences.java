class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) 
    {
        int curr=0,max=0;
        int min=0;

        for(int i=0;i<differences.length;i++)
        {
            curr=curr+differences[i];
            max=Math.max(curr,max);
            min=Math.min(curr,min);

            if(max-min>upper-lower)
             return 0;
        }
        return(upper-lower)-(max-min)+1;
    }
}