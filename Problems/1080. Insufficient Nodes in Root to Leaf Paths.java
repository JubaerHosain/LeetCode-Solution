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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(deleteNodes(root, limit, 0)) return null;
        return root;
    }
    
    private boolean deleteNodes(TreeNode root, int limit, int sum){
        if(root == null){
            return true;
        }
        
        sum += root.val;
        if(root.left == null && root.right == null){
            return sum < limit;
        }
        
        boolean left = deleteNodes(root.left, limit, sum);
        boolean right = deleteNodes(root.right, limit, sum);
      
        if(left) root.left = null;
        if(right) root.right = null;
        
        return left && right;
    }
}
