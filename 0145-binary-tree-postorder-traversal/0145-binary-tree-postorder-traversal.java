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
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> result=new ArrayList<>();
        postOrderTraversal(root,result);
        return result;
    }

    public void postOrderTraversal(TreeNode node, List<Integer> res)
    {
        if(node==null)
         return;

        postOrderTraversal(node.left, res);
        
        postOrderTraversal(node.right,res);
        res.add(node.val);
        
    }
}