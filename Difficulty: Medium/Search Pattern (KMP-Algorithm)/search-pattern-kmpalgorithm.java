//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    // Preprocess the pattern to build the prefix table (partial match table)
    private int[] buildPrefixTable(String pat) {
        int m = pat.length();
        int[] lps = new int[m];  // Longest Prefix Suffix (LPS) array
        int j = 0;  // Length of the previous longest prefix suffix
        for (int i = 1; i < m; i++) {
            while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                j = lps[j - 1];  // Fallback to the previous best match
            }
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

    // Search for all occurrences of the pattern in the text
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> al = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        if (m == 0 || n == 0) return al;

        // Build the prefix table for the pattern
        int[] lps = buildPrefixTable(pat);
        
        int i = 0;  // Index for text
        int j = 0;  // Index for pattern

        // Loop through the text to find matches
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {  // Found a match
                al.add(i - j);  // Add the starting index of the match
                j = lps[j - 1];  // Use the LPS array to skip redundant comparisons
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];  // Use the LPS array to skip characters in the pattern
                } else {
                    i++;
                }
            }
        }

        return al;
    }
  
}