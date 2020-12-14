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
    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int[] sum = {0};
        dfs(root, sum);
        
        return sum[0];
    }
    
    private void dfs(TreeNode root, int[] sum){
        if(root.left != null){
            dfs(root.left, sum);
        }
        if(root.right != null){
            dfs(root.right, sum);
        }
        
        int left = 0, right = 0;
        if(root.left == null){
            left = 0;
        }
        else{
            left = root.left.val;
        }
        
        if(root.right == null){
            right = 0;
        }
        else{
            right = root.right.val;
        }
        
        root.val += left + right;
        sum[0] += Math.abs(left-right);
    }
}
