//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {

    int countPairs(int arr[], int target) 
    {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int pairCount = 0;

        for (int num : arr) {
            // Check if the complement exists in the map
            int complement = target - num;
            if (freqMap.containsKey(complement)) {
                pairCount += freqMap.get(complement);
            }

            // Update the frequency of the current number
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return pairCount;
        // int pair=0;
        
        // for(int i=0;i<arr.length-1;i++)
        // {
        //     for(int j=i+1;j<arr.length;j++)
        //     {
        //         if(arr[i]+arr[j]==target)
        //          pair++;
        //     }
        // }
        // return pair;
        
        // HashSet<Integer> s=new HashSet<>();
        // int pair=0;
        // for(int nums:arr)
        // {
        //     int count=target-nums;
            
        //     if(s.contains(count))
        //      pair++;
            
        //     s.add(nums);
        // }
        // return pair;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends