//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
    //     // Code here
    //     int min=10000000;
    //     int index=0;
    //     int sum=0;
        
    //     for(int i=0;i<prices.length;i++)
    //     {
    //         if(prices[i]<min)
    //         {
    //           min=prices[i];
    //           index=i;
    //         }
    //     }
        
    //     for(int i=index;i<prices.length;i++)
    //     {
    //         if()
    //     }
       // Edge case: If the prices array has fewer than 2 elements, no transaction is possible
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize variables:
        int minPrice = Integer.MAX_VALUE;  // The minimum price encountered so far
        int maxProfit = 0;  // The maximum profit

        // Traverse through the array of prices
        for (int price : prices) {
            // Update the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate the potential profit if we sold at the current price
            int profit = price - minPrice;

            // Update the maximum profit if the current profit is higher
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }
}