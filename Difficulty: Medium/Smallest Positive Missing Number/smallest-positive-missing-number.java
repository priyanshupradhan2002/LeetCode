//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) 
    {
//         int small_num=1;
        
//       for(int i=0;i<arr.length;i++)
//       {
//           for(int j=0;j<arr.length;j++)
//           {
//               if(arr[j]==small_num)
//               {
//                   small_num++;
//                   break;
//               }
//           }
//       }
//       return small_num;
//     }
// }

     HashSet<Integer> set=new HashSet<>();
     
     for(int num:arr)
     {
         set.add(num);
     }
     int smallNum=1;
     while(set.contains(smallNum))
        smallNum++;
        
    return smallNum;
    }
}
  
