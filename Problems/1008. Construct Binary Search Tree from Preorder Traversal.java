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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        
        for(int val: preorder){
           root = buildBST(root, val);
        }
        
        return root;
    }
    
    private TreeNode buildBST(TreeNode root, int val){
        if(root == null){
            return root = new TreeNode(val);
        }
        
        if(val < root.val){
            root.left = buildBST(root.left, val);
        }
        
        if(val > root.val){
            root.right = buildBST(root.right, val);
        }
        
        return root;
    }
}
