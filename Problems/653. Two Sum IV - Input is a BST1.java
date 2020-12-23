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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        return hasFind(root, k, set);
    }
    
    private boolean hasFind(TreeNode root, int target, HashSet<Integer> set){
        if(root == null){
            return false;
        } else if(set.contains(target-root.val)){
            return true;
        }
        
        set.add(root.val);
        return hasFind(root.left, target, set) || hasFind(root.right, target, set);
    }
}
