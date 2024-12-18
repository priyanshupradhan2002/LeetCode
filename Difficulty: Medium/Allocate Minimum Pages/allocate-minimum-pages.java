//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    
    // Helper function to check if it's possible to allocate books such that no student has more than 'maxPages' pages
    private static boolean canAllocateBooks(int[] arr, int k, int maxPages) {
        int studentCount = 1;  // Start with the first student
        int currentSum = 0;    // To track the current sum of pages assigned to a student

        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                // Need to assign a new student
                studentCount++;
                currentSum = pages;
                if (studentCount > k) {
                    return false;  // More students than allowed
                }
            } else {
                currentSum += pages;  // Assign this book to the current student
            }
        }
        return true;
    }

    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        
        // If there are fewer books than students, return -1 as allocation is not possible
        if (n < k) {
            return -1;
        }

        // The minimum number of pages a student can get is the maximum pages of a single book
        // The maximum number of pages a student can get is the sum of all pages
        int left = 0, right = 0;
        for (int pages : arr) {
            left = Math.max(left, pages);  // Maximum pages a student could get (one book per student)
            right += pages;  // Sum of all pages (one student gets all books)
        }

        // Perform binary search to find the minimum possible maximum number of pages
        int result = right;  // Start with the worst case where one student gets all books
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if it's possible to allocate books such that no student gets more than 'mid' pages
            if (canAllocateBooks(arr, k, mid)) {
                result = mid;  // This allocation is possible, so record the result
                right = mid - 1;  // Try to find a smaller maximum
            } else {
                left = mid + 1;  // Increase the number of pages per student
            }
        }

        return result;
    }
}
