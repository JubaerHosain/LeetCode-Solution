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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        preOrder(root,  list);
        
        TreeNode newRoot = new TreeNode(list.get(0), null, null);
        TreeNode current = newRoot;
        
        for(int i = 1; i < list.size(); i++){
            current.right = new TreeNode(list.get(i), null, null);
            current = current.right;
        }
        
        return newRoot;
    }
    
    private void preOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right, list);
    }
}
