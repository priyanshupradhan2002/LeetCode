//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) 
    {
    //   ArrayList<Integer> result=new ArrayList<>();
    //     int start=0;
    //     int currentsum=0;
    //     int end;
    //     for( end=0;end<arr.length;end++)
    //     {
    //       currentsum+=arr[end]; 
    //     }
        
    //      while (currentsum > target) {
    //             currentsum -= arr[start++];
    //         }
        
    //     if(currentsum==target)
    //     {
    //         result.add(start+1);
    //         result.add(end+1);
    //         return result;
    //     }
         
    //      result.add(-1);
    //      return result;
    ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int currentSum = 0; // Declare currentSum outside the loop

        for (int end = 0; end < arr.length; end++) { // Declare end here
            currentSum += arr[end];

            while (currentSum > target) {
                currentSum -= arr[start++];
            }

            if (currentSum == target) {
                result.add(start + 1); // 1-based index for start
                result.add(end + 1);   // 1-based index for end
                return result;
            }
        }

        result.add(-1); // No subarray found
        return result;
    }
}
 