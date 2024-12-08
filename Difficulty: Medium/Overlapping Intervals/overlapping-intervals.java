//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        if (arr.length <= 1) {
            return Arrays.asList(arr);
        }

        // Sort the intervals based on the start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
      // Initialize with the first interval
        int[] currentInterval = arr[0];
        merged.add(currentInterval);

        for (int[] interval : arr) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check for overlap
            if (currentEnd >= nextStart) {
                // Merge intervals by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged;
    }
}