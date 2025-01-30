//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

//import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n]; // board[i] represents the row position of the queen in the i-th column
        solve(0, n, board, result);
        return result;
    }

    private void solve(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            result.add(constructSolution(board));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (isValid(board, col, row)) {
                board[col] = row; // Place queen
                solve(col + 1, n, board, result);
            }
        }
    }

    private boolean isValid(int[] board, int col, int row) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false; // Same row or same diagonal
            }
        }
        return true;
    }

    private ArrayList<Integer> constructSolution(int[] board) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int value : board) {
            solution.add(value);
        }
        return solution;
    }

}
