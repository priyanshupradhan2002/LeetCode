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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> result=new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    public void inOrderTraversal(TreeNode node, List<Integer> res)
    {
        if(node==null)
         return;
        
        inOrderTraversal(node.left,res);
        res.add(node.val);
        inOrderTraversal(node.right,res);
    }
}