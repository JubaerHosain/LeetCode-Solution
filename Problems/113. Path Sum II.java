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
    private void getPath(TreeNode root, int curr, int sum, List<Integer> path, List<List<Integer>> res){
        if(root.left == null && root.right == null){
            path.add(root.val);
            curr += root.val;
            
            if(curr == sum){
               res.add(new ArrayList(path)); 
            }
            return;
        }
        
        curr += root.val;
        path.add(root.val);
        if(root.left != null){
            getPath(root.left, curr, sum, path, res);
            
            if(path.size() > 0){
                path.remove(path.size()-1);
            }
        }
        
        if(root.right != null){
            getPath(root.right, curr, sum, path, res);
            
            if(path.size() > 0){
                path.remove(path.size()-1);
            }
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        getPath(root, 0, sum, path, res);
        
        return res;
    }
}
