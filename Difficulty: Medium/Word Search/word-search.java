//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0) && dfs(mat, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(char[][] mat, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        char temp = mat[i][j];
        mat[i][j] = '#'; // Mark as visited
        
        boolean found = dfs(mat, word, i + 1, j, index + 1) ||
                        dfs(mat, word, i - 1, j, index + 1) ||
                        dfs(mat, word, i, j + 1, index + 1) ||
                        dfs(mat, word, i, j - 1, index + 1);
        
        mat[i][j] = temp; // Restore original character
        return found;
    }
}
