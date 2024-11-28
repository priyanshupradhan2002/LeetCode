//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Handle the sign (either '+' or '-')
        boolean isNegative = false;
        if (i < n && s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }
        
        // Step 3: Read the integer and ignore leading zeros
        long result = 0; // Use long to handle overflow before casting to int
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            i++;
            
            // Step 4: Check for overflow
            if (result > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        // Step 5: Apply the sign
        if (isNegative) {
            result = -result;
        }
        
        // Step 6: Return the result as an int, within the range of a 32-bit signed integer
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) result;
        }
    }
}
