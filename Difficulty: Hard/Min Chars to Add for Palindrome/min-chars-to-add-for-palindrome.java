//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public static int minChar(String s) {
 String rev_s = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev_s;
        
        // Apply KMP LPS (Longest Prefix Suffix) array
        int[] lps = new int[combined.length()];
        
        int j = 0;  // Length of the previous longest prefix suffix
        for (int i = 1; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];  // Fall back to the previous potential match
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;  // If matched, increase the length of the prefix suffix
            }
            lps[i] = j;  // Store the length of the current prefix suffix
        }
        
        // The LPS value at the last index of combined string gives the longest palindromic prefix
        int longestPalindromePrefix = lps[combined.length() - 1];
        
        // We need to add the rest of the characters from the original string
        return s.length() - longestPalindromePrefix;    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends