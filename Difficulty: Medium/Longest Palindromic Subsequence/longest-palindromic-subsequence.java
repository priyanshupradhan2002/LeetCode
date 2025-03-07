//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestPalinSubseq(String s) 
    {
      int n=s.length();
    String rev = new StringBuilder(s).reverse().toString(); // Reverse the string

      
      int[][] dp=new int[n+1][n+1];
      
      
      for(int i=1;i<=n;i++)
      {
          for(int j=1;j<=n;j++)
          {
              if(s.charAt(i-1)==rev.charAt(j-1))
              {
                  dp[i][j]=dp[i-1][j-1]+1;
              }
              else
              {
                  dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
              }
          }
      }
      return dp[n][n];
    }
}