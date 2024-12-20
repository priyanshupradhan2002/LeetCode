//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;

        // List to store the spiral order elements
        ArrayList<Integer> res = new ArrayList<>();

        // 2D array to keep track of visited cells
        boolean[][] vis = new boolean[m][n];

        // Change in row index for each direction
        int[] dr = { 0, 1, 0, -1 };

        // Change in column index for each direction
        int[] dc = { 1, 0, -1, 0 };

        // Initial position in the matrix
        int r = 0, c = 0;

        // Initial direction index (0 corresponds to 'right')
        int idx = 0;

        // Iterate through all elements in the matrix
        for (int i = 0; i < m * n; ++i) {

            // Add current element to result list
            res.add(mat[r][c]);

            // Mark current cell as visited
            vis[r][c] = true;

            // Calculate the next cell coordinates based on
            // current direction
            int newR = r + dr[idx];
            int newC = c + dc[idx];

            // Check if the next cell is within bounds and not
            // visited
            if (0 <= newR && newR < m && 0 <= newC && newC < n
                    && !vis[newR][newC]) {

                // Move to the next row
                r = newR;

                // Move to the next column
                c = newC;
            } else {

                // Change direction (turn clockwise)
                idx = (idx + 1) % 4;

                // Move to the next row according to new
                // direction
                r += dr[idx];

                // Move to the next column according to new
                // direction
                c += dc[idx];
            }
        }

        return res;
    }
}
