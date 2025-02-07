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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> result=new ArrayList<>();
        preOrderTraversal(root,result);
        return result;
    }

    public void preOrderTraversal(TreeNode node, List<Integer> res)
    {
        if(node==null)
         return;
        
        res.add(node.val);
        preOrderTraversal(node.left,res);
        preOrderTraversal(node.right,res);
    }
}