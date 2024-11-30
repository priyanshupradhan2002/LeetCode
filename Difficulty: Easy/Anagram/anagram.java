//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) 
    {
         // If lengths are not equal, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Frequency array for lowercase English letters ('a' to 'z')
        int[] freq = new int[26]; // array to store frequency of characters
        
        // Iterate through both strings and count the characters
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;  // Increment frequency for s1
            freq[s2.charAt(i) - 'a']--;  // Decrement frequency for s2
        }

        // If all counts in the frequency array are zero, the strings are anagrams
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}