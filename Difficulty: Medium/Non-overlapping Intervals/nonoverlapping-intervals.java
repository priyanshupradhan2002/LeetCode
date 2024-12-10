//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    static int minRemoval(int intervals[][]) {
        // Edge case: if there are no intervals, return 0
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int lastEnd = intervals[0][1]; // Track the end time of the last non-overlapping interval
        
        // Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) 
        {
            // If the current interval's start time is less than the last end time,
            // it means the intervals overlap and we need to remove one.
            if (intervals[i][0] < lastEnd) {
                count++;
            } else {
                // If there's no overlap, update lastEnd to be the current interval's end time
                lastEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}

// class Solution {
//     static int minRemoval(int intervals[][]) 
//     {
//         int st=0;
//         int end=0;
//         int count=0;
//         for(int[] arr:intervals)
//         {
//             int i=1;
//              st=intervals[i][0];
//              end=arr[1];
//              i++;
             
//              if(end<st)
//               count++;
             
//         }
//         return count;
//     }
// }
