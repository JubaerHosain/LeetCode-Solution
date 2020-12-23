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
    public int sumRootToLeaf(TreeNode root) {
        return getSum(root, new StringBuilder());
    }
    
    private int getSum(TreeNode root, StringBuilder sb){
        if(root.left == null && root.right == null){
            sb.append(root.val);
            int sum = Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length()-1);
            return sum;
        }
        
        sb.append(root.val);
        int left = 0, right = 0;
        if(root.left != null){
            left = getSum(root.left, sb);
        }
        if(root.right != null){
            right = getSum(root.right, sb);
        }
        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        
        return left+right;
    }
}
