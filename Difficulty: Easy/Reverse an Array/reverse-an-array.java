//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public void reverseArray(int arr[]) 
    {
    //   List<Integer> list=new ArrayList<>();
    //   for(int num:arr)
    //   {
    //       list.add(num);
    //   }
    //   //Reverse The list
    //   Collections.reverse(list);
       
    //   //Adding the list value in array
    //   for(int i=0;i<newArray.length;i++)
    //   {
    //       newArray[i]=list.get(i);
    //   }
       
       
       
       int[] arr2=new int[arr.length];
       for(int i=0;i<arr.length;i++)
       {
           arr2[i]=arr[(arr.length-1)-i];
       }
       
       for(int i=0;i<arr.length;i++)
       {
           arr[i]=arr2[i];
       }
    }
}