//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) 
    {
       Arrays.sort(arr);
       int count=0;
    //   for(int i=0;i<arr.length-2;i++)
    //   {
    //       int j=i+1;
    //       int k=arr.length-1;
    //       while(j<k)
    //       {
    //           if(arr[i]+arr[j]>arr[k])
    //           {
    //               count += (j - i);
    //                 j--; // Decrement the end pointer
    //             } else {
    //                 i++; // Increment the start pointer
    //             }
    //   }}
            for (int k = arr.length - 1; k >= 2; k--)
            {
            int i = 0;       // Start pointer
            int j = k - 1;   // End pointer

            // Two-pointer approach
            while (i < j) 
            {
                if (arr[i] + arr[j] > arr[k]) {
                    // All pairs from i to j will satisfy the condition
                    count += (j - i);
                    j--; // Decrement the end pointer
                } else {
                    i++; // Increment the start pointer
                }
            }
}
    return count;
    }
}