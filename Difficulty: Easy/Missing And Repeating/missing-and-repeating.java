//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) 
    {
    //     ArrayList<Integer> result=new ArrayList<>();
    //     HashSet<Integer> s=new HashSet<>();
    //     int max=0;
    //   for(int i=0;i<arr.length;i++)
    //   {
    //       if(s.contains(arr[i]))
    //           result.add(arr[i]);
    //       else
    //           s.add(arr[i]);
    //       if(arr[i]>max)
    //       {
    //           max=arr[i];
    //       }
    //   }
       
    //   for(int i=1;i<max;i++)
    //   {
    //       if(!s.contains(i))
    //         result.add(i);
    //   }
    //   return result;
    ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        boolean[] seen = new boolean[n + 1]; // To track seen numbers

        int repeated = -1;
        int missing = -1;

        // Find the repeated number
        for (int num : arr) {
            if (seen[num]) {
                repeated = num;
            } else {
                seen[num] = true;
            }
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }

        result.add(repeated);
        result.add(missing);
        return result;
    }
}
