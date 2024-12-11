//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge the arrays
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Start from the end of a[] and the beginning of b[]
        int i = n - 1;
        int j = 0;

        // Traverse through the arrays and swap the elements if needed
        while (i >= 0 && j < m) {
            // If the current element of a[] is greater than the current element of b[]
            if (a[i] > b[j]) {
                // Swap the elements
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                
                // Move the pointer in b[] to the next element
                j++;
            } else {
                // Move the pointer in a[] to the previous element
                i--;
            }
        }

        // Sort both arrays after the swap operation
        Arrays.sort(a);  // Sorting the first array
        Arrays.sort(b);  // Sorting the second array
    }
}