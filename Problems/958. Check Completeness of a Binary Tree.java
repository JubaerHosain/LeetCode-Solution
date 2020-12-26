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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean leftMostLeaf = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 1; i <= size; i++){
                TreeNode node = queue.poll();
                
                if((node.left != null || node.right != null) && leftMostLeaf){
                    return false;
                }
                if(node.left == null || node.right == null){
                    leftMostLeaf = true;
                }
                if(node.left == null && node.right != null){
                    return false;
                }
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        
        return true;
    }
}
