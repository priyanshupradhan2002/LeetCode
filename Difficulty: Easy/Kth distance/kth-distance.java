//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // Create a HashMap to store element indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is already in the map
            if (map.containsKey(arr[i])) {
                // If the element is found, check the distance
                int prevIndex = map.get(arr[i]);
                if (i - prevIndex <= k) {
                    return true;  // Found a duplicate within the distance k
                }
            }
            // Update the map with the current index of the element
            map.put(arr[i], i);
        }
        
        // Return false if no such duplicates are found
        return false;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.checkDuplicatesWithinK(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends