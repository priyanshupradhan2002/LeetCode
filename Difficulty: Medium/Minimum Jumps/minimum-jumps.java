//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        // If the first element is 0, we can't move anywhere.
        if (arr[0] == 0) {
            return -1;
        }
        
        int jumps = 0;   // Number of jumps
        int farthest = 0; // The farthest index we can reach at any point
        int currentEnd = 0; // End of the current jump range
        
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest reachable index from the current index
            farthest = Math.max(farthest, i + arr[i]);
            
            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;  // We make a jump
                currentEnd = farthest;  // Update the current jump range's end
                
                // If we can reach or exceed the last index, we're done
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }
        
        // If we exit the loop without reaching the last index, return -1
        return -1;
    }
}
