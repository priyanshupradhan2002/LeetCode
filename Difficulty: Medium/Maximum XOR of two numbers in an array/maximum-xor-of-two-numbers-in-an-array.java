//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Trie Node class
    class TrieNode {
        TrieNode[] children = new TrieNode[2]; // for bit 0 and bit 1
    }

    TrieNode root = new TrieNode();

    // Insert number into Trie
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Find maximum XOR of num with any number in the Trie
    private int findMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppBit = 1 - bit;
            if (node.children[oppBit] != null) {
                maxXor |= (1 << i);
                node = node.children[oppBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public int maxXor(int[] arr) {
        int max = 0;
        insert(arr[0]); // Insert first number
        for (int i = 1; i < arr.length; i++) {
            int xor = findMaxXor(arr[i]);
            max = Math.max(max, xor);
            insert(arr[i]); // insert after checking
        }
        return max;
    }
}
