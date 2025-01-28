//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) 
    {
        TreeSet<String> treeset=new TreeSet<>();
        generatePermutation(s.toCharArray(),0,treeset);
        return new ArrayList<>(treeset);
    }
    public void generatePermutation(char[] ch,int index, TreeSet<String> treeset)
    {
        if(index==ch.length)
        {
            treeset.add(new String(ch));
            return;
        }
        
        for(int i=index;i<ch.length;i++)
        {
            swap(ch,i,index);
            generatePermutation(ch,index+1,treeset);
            swap(ch,i,index);
        }
    }
    public void swap(char[] ch,int i,int j)
    {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
}