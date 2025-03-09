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

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String s) 
    {
        int n=s.length();
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            count+=calculateSubString(s,i,i);//For Odd Number
            count+=calculateSubString(s,i,i+1);//For Even Numbers
        }
        return count;
    }
    public static int calculateSubString(String s, int left, int right)
    {
        int n=s.length();
        int count=0;
        
        
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right))
        {
            if(right-left+1>=2)
            {
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
}