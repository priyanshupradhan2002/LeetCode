//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Base cases for first two steps
        int prev2 = cost[0]; // The cost to reach step 0
        int prev1 = cost[1]; // The cost to reach step 1
        
        // Loop through from step 2 to the top
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;  // Move prev1 to prev2
            prev1 = current; // Update prev1 to current
        }
        
        // To reach the top, we take the minimum of reaching the last step or the second last step
        return Math.min(prev1, prev2);
    }
}
