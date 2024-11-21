//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends



//import java.util.*;



class Solution {
    public List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if the array is empty, return an empty list
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Step 1: Count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Check which elements have frequency greater than n / 3
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }
        
        // Step 3: Sort the result to return in increasing order
        Collections.sort(result);
        
        return result;
    }
}