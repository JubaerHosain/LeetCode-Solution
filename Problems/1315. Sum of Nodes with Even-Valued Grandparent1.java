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
        
        
        return getSum(root);
    }
    
    private int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int sum = 0;
        if(root.val%2 == 0){
            if(root.left != null){
                TreeNode chil = root.left;
                sum += (chil.left != null) ? chil.left.val:0;
                sum += (chil.right != null) ? chil.right.val:0;
            }
            if(root.right != null){
                TreeNode chil = root.right;
                sum += (chil.left != null) ? chil.left.val:0;
                sum += (chil.right != null) ? chil.right.val:0;
            }
        }
        
       return sum +  getSum(root.left) + getSum(root.right);
    }
}
