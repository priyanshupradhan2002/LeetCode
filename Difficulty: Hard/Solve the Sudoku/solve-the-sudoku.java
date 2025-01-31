//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to solve the Sudoku.
    static boolean solveSudoku(int[][] mat) {
        return solve(mat, 0, 0);
    }

    // Helper function to solve Sudoku using backtracking
    private static boolean solve(int[][] board, int row, int col) {
        // If we have reached the end of the board, return true
        if (row == 9) {
            return true;
        }

        // If we have reached the end of a row, move to the next row
        if (col == 9) {
            return solve(board, row + 1, 0);
        }

        // If the cell is already filled, move to the next column
        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }

        // Try placing numbers from 1 to 9 in the cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;

                // Recursively solve for the next cell
                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack if placing num didn't lead to a solution
                board[row][col] = 0;
            }
        }

        // No valid number found, return false
        return false;
    }

    // Function to check if placing a number is valid
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check if the number is in the current row or column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check if the number is in the current 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Function to print the solved Sudoku
    static void printGrid(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}