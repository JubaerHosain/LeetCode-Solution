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
        TreeNode root = new TreeNode(preorder[0]);
        
        buildBST(root, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
        
        return root;
    }
    
    private int buildBST(TreeNode root, int pos, int min, int max, int[] values){
        if(pos == values.length || values[pos] < min || values[pos] > max){
            return pos;
        }
        
        if(root.val > values[pos]){
            root.left = new TreeNode(values[pos]);
            pos++;
            pos = buildBST(root.left, pos, min, root.val-1, values);
        }
        
        if(pos == values.length || values[pos] < min || values[pos] > max){
            return pos;
        }
        
        root.right = new TreeNode(values[pos]);
        pos++;
        pos = buildBST(root.right, pos, root.val+1, max, values);
        
        return pos;
    }
}
