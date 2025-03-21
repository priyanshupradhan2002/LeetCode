/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) 
    {
        //Create one list to return the result
        List<Integer> result=new ArrayList<>();
        //Check wheter root is empty or not
        if(root==null)
         return result;
         Queue<TreeNode> queue=new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty())
         {
            int n=queue.size();
            TreeNode current=queue.peek();
            int max=current.val;
            for(int i=0;i<n;i++)
            {
                current=queue.poll();
                max=Math.max(max,current.val);
                if(current.left!=null)
                 queue.add(current.left);
                if(current.right!=null)
                 queue.add(current.right);
            }
            result.add(max);
         }
         return result;
    }
}