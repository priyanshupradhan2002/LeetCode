//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        if (e == 0) return 1.0;  // Base case: any number to the power of 0 is 1
        
        double result = 1.0;
        long exp = Math.abs((long)e);  // Convert to long to handle edge cases (like Integer.MIN_VALUE)
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= b;
            }
            b *= b;
            exp /= 2;
        }
        
        return (e < 0) ? 1.0 / result : result;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends