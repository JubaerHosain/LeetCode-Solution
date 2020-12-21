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
    String result = "";
    
    public String smallestFromLeaf(TreeNode root) {
        getSmallest(root, new StringBuilder());
        
        return result;
    }
    
    private void getSmallest(TreeNode root, StringBuilder sb){
        if(root.left == null && root.right == null){
            char val = (char)(root.val+'a');
            sb.insert(0, val);
            
            String leafString = sb.toString();
            if(result.length() == 0){
                result = leafString;
            } else{
                result = (leafString.compareTo(result) < 0) ? leafString:result;
            }
            
            sb.deleteCharAt(0);
            return;
        }
        
        char val = (char)(root.val+'a');
        sb.insert(0, val);
        if(root.left != null){
            getSmallest(root.left, sb);
        }
        
        if(root.right != null){
            getSmallest(root.right, sb);
        }
        
        sb.deleteCharAt(0);
    }
}
