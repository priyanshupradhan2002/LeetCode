//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

    class Solution {
    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;

            // If complement exists in the map, it contributes to the count
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            // Add current number to the map or update its frequency
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}



    // int countPairs(int arr[], int target) 
    // {
    //      int count=0;
    //     for(int i=0;i<arr.length-1;i++)
    //     {
    //         for(int j=i+1;j<arr.length;j++)
    //         {
    //             if(arr[i]+arr[j]==target)
    //             {
    //                 count++;
    //             }
    //         }
    //     }
        
    //     return count;
    // }


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends