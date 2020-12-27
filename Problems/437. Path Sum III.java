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
    public int pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        
        return getNumberOfPath(root, sum, path);
    }
    
    private int getNumberOfPath(TreeNode root, int sum, List<Integer> path){
        if(root == null){
            return 0;
        }
        
        path.add(root.val);
        int pathCount = 0, currSum = 0, size = path.size();
        while(--size >= 0){
            currSum += path.get(size);
            if(currSum == sum){
                pathCount++;
            }
        }
        
        pathCount += getNumberOfPath(root.left, sum, path);
        pathCount += getNumberOfPath(root.right, sum, path);
        path.remove(path.size()-1);
        
        return pathCount;
    }
}
