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
    int minDiff = Integer.MAX_VALUE;
    Integer val = null;
    
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return minDiff;
    }
    
    private void getMin(TreeNode root){
        if(root == null){
            return;
        }
        
        getMin(root.left);
        if(val == null){
            val = root.val;
        } else {
            minDiff = Math.min(minDiff, Math.abs(val-root.val));
            val = root.val;
        }
        getMin(root.right);
    }
}





