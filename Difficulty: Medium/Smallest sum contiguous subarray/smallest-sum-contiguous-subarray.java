//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        int curr_sum=0;
        int Total_Sum=Integer.MAX_VALUE;
        
        for(int i=0;i<a.length;i++)
        {
            curr_sum+=a[i];
            Total_Sum=Math.min(Total_Sum,curr_sum);
            
            if(curr_sum>0)
              curr_sum=0;
        }
        return Total_Sum;
    }
}