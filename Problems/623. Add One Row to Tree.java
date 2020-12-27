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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null){
            return null;
        }
        
        return addRow(root, v, d);
    }
    
    private TreeNode addRow(TreeNode root, int v, int d){
        if(root == null){
            return null;
        } else if(d == 1){
            root = new TreeNode(v, root, null);
        } else if(d == 2) {
            root.left = new TreeNode(v, root.left, null);
            root.right = new TreeNode(v, null, root.right);
        } else {
            root.left = addRow(root.left, v, d-1);
            root.right = addRow(root.right, v, d-1);
        }
        
        return root;
    }
}
