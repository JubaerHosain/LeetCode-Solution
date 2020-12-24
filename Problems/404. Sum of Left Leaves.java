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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        } else if (root.left != null && isLeaf(root.left)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    private boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }
}
