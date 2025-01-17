//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());

        while (t-- > 0) {
            String line = scanner.nextLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxIndexDiff(nums));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
// class Solution {
//     // Function to find the maximum index difference.
//     int maxIndexDiff(int[] arr) 
//     {

//       int difference=0;
//       for(int i=0;i<arr.length-1;i++)
//       {
//           for(int j=i+1;j<arr.length;j++)
//           {
//               if(arr[i]<=arr[j] && i<=j)
//               {
//                   int diff=j-i;
//                   if(diff>difference)
//                   {
//                       difference=diff; 
//                   }
//               }
//           }
//       }
//       return difference;
//     }
// }
class Solution {
    // Function to find the maximum index difference.
    int maxIndexDiff(int[] arr) {
        int n = arr.length;
        
        // Step 1: Create and fill leftMin[] and rightMax[] arrays
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        // Fill leftMin[]: leftMin[i] contains the minimum value from arr[0] to arr[i]
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }
        
        // Fill rightMax[]: rightMax[j] contains the maximum value from arr[j] to arr[n-1]
        rightMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        }
        
        // Step 2: Use two-pointer technique to find the maximum index difference
        int i = 0, j = 0, maxDiff = 0;
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                // Valid pair, calculate difference
                maxDiff = Math.max(maxDiff, j - i);
                j++; // Move the right pointer to explore a larger difference
            } else {
                i++; // Move the left pointer to find a smaller minimum
            }
        }
        
        return maxDiff;
    }
}
