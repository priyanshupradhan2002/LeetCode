//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isParenthesisBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) 
    {
        char[] ch=s.toCharArray();
        Stack<Character> st=new Stack<>();
        
        for(char c:ch)
        {
            if(c=='{' || c=='(' || c=='[')
            {
                st.push(c);
            }
           else if (c == '}' || c == ')' || c == ']') 
           {
                if (st.isEmpty()) 
                {
                    return false; // No opening bracket to match
                }
              char top=st.pop();
              if ((c == '}' && top != '{') ||
                    (c == ')' && top != '(') ||
                    (c == ']' && top != '[')) {
                    return false; // Mismatched bracket
                }
           }
        }
         return st.isEmpty();
    }
}
