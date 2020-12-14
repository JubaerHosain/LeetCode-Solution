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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        
        getPath(root, list, null);
        
        return list;
    }
    
    private void getPath(TreeNode root, List<String> list, String path){
        if(root == null){
            return;
        }
        
        if(path == null){
            path = root.val+"";
        }
        else{
             path += "->" + root.val;
        }
        
        getPath(root.left, list, path);
        getPath(root.right, list, path);
        
        if(root.left == null && root.right == null){
            list.add(path);
        }
    }
}






