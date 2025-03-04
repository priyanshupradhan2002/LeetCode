//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int lis(int arr[]) {
        // code here
         ArrayList<Integer> sub = new ArrayList<>();

        for (int num : arr)
        {
            // Find the index where 'num' should be placed
            int pos = Collections.binarySearch(sub, num);
            
            // If 'num' is not found, binarySearch() returns (-insertion_point - 1)
            if (pos < 0) {
                pos = -(pos + 1); // Convert to valid index
            }
            
            // Replace element at 'pos' or append to the list
            if (pos < sub.size()) {
                sub.set(pos, num);
            } else {
                sub.add(num);
            }
        }
        
        return sub.size();
    }
}