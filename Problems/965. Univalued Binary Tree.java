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
    public boolean isUnivalTree(TreeNode root) {
        return getUnivalued(root, root.val);
    }
    
    private boolean getUnivalued(TreeNode root, int val){
        if(root == null){
            return true;
        }
        
        return (root.val == val) && getUnivalued(root.left, val) && getUnivalued(root.right, val);
    }
}
