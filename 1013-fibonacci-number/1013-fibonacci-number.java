class Solution {
    public int fib(int n) 
    {
        if(n==0 || n==1)
         return n;
    int[] dp=new int[n+1];
     dp[0]=0;
     dp[1]=1;
     int nextNum=0;
        for(int i=2;i<=n;i++)
        {
             nextNum=dp[i-2]+dp[i-1];
            // dp[i-1]=dp[i-2];
            dp[i]=nextNum;
           // nextNum = dp[]
           
        }
        return dp[n-1]+dp[n-2];
    }
}