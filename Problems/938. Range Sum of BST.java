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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = {0};
        getSum(root, low, high, sum);
        
        return sum[0];
    }
    
    private void getSum(TreeNode node, int low, int high, int[] sum){
        if(node.val >= low && node.val <= high){
            sum[0] += node.val;
        }
        
        if(node.left != null){
            getSum(node.left, low, high, sum);
        }
        
        if(node.right != null){
            getSum(node.right, low, high, sum);
        }
    }
    
}
