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
class FindElements {
    HashSet<Integer> set;
    
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        recoverTree(root, 0);
    }
    
    private void recoverTree(TreeNode root, int val){
        if(root == null){
            return;
        }
        
        set.add(val);
        root.val = val;
        recoverTree(root.left, 2*val+1);
        recoverTree(root.right, 2*val+2);
    }
    
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
