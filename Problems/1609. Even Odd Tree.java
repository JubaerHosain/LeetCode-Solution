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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int minMax = (level%2 == 0) ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            
            while(size-- > 0){
                TreeNode node = queue.poll();
                int value = node.val;
                
                if(level%2 == 0){
                    if(value%2 == 1 && value > minMax){
                        minMax = value;
                    } else {
                        return false;
                    }
                } else{
                    if(value%2 == 0 && value < minMax){
                        minMax = value;
                    } else {
                        return false;
                    }
                }
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        
        return true;
    }
}
