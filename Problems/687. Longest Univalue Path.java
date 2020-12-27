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
    int maxLength = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        getMaxLength(root);
        
        return maxLength;
    }
    
    private int getMaxLength(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = getMaxLength(root.left);
        int right = getMaxLength(root.right);
        int currLeft = 0, currRight = 0;
        
        if(root.left != null && root.val == root.left.val){
            currLeft = left+1;
        }
        if(root.right != null && root.val == root.right.val){
            currRight = right+1;
        }
        
        maxLength = Math.max(maxLength, currLeft+currRight);
        
        return Math.max(currLeft, currRight);
    }
}
