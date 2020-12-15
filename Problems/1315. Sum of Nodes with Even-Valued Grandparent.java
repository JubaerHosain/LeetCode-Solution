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
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = {0};
        getSum(root, sum);
        
        return sum[0];
    }
    
    private void getSum(TreeNode root, int[] sum){
        if(root == null){
            return;
        }
        else if(root.val%2 == 0){
            if(root.left != null){
                TreeNode chil = root.left;
                sum[0] += (chil.left != null) ? chil.left.val:0;
                sum[0] += (chil.right != null) ? chil.right.val:0;
            }
            if(root.right != null){
                TreeNode chil = root.right;
                sum[0] += (chil.left != null) ? chil.left.val:0;
                sum[0] += (chil.right != null) ? chil.right.val:0;
            }
        }
        
        getSum(root.left, sum);
        getSum(root.right, sum);
    }
}
