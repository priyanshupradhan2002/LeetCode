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
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        
        // dp[i][j] stores the minimum number of multiplications needed to multiply matrices i to j
        int[][] dp = new int[n - 1][n - 1];
        
        // We iterate over the chain length starting from 2 to n-1
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try all the possible points where we split the chain
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + arr[i] * arr[k + 1] * arr[j + 1];
                    dp[i][j] = Math.min(dp[i][j], q);
                }
            }
        }

        // The result is in dp[0][n-2] (from matrix 1 to matrix n-1)
        return dp[0][n - 2];
    }
}
