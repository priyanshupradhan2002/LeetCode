//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        //Creating a map to enter only unique value
       // Arrays.sort(arr);
        //  HashMap<Integer,Integer> map=new HashMap<>();
        
        // int index=0;
        // //putting all the value in map
        // for(int i=0;i<arr.length;i++)
            
        // {
            
        //     if(!map.containsValue(arr[i]))
        //     {
        //         map.put(index,arr[i]);
        //         index++;
        //     }
            
        // }
        
        // if(map.size()<2)
        //   return -1;
         
        //  return map.get(map.size()-2);
          
          
        // TreeSet<Integer> set=new TreeSet<>();
        
        // for(int i=0;i<arr.length;i++)
        // {
        //     set.add(arr[i]);
        // }
        
        // if(set.size()<2)
        //  return -1;
         
        //  set.pollLast();
         
        //  return set.pollLast();
        
         // Use a HashSet to store unique values
        HashSet<Integer> set = new HashSet<>();

        // Insert all elements into the HashSet to ensure uniqueness
        for (int num : arr) {
            set.add(num);
        }

        // If there are fewer than two unique elements, return -1
        if (set.size() < 2) {
            return -1;
        }

        // Convert the HashSet to a list
        ArrayList<Integer> uniqueValues = new ArrayList<>(set);

        // Sort the list in ascending order
        Collections.sort(uniqueValues);

        // Return the second largest element, which is the second-to-last element in the sorted list
        return uniqueValues.get(uniqueValues.size() - 2);
    }
}