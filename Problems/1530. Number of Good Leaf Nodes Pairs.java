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
    int count = 0;
    
    public int countPairs(TreeNode root, int distance) {
        counting(root, distance);
        return count;
    }
    
    private List<Integer> counting(TreeNode root, int dist){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        
        List<Integer> left = counting(root.left, dist);
        List<Integer> right = counting(root.right, dist);
        
        if(left.isEmpty() && right.isEmpty()){
            list.add(1);
            return list;
        }
        
        if(!left.isEmpty() && !right.isEmpty()){
            for(int l: left){
                for(int r: right){
                    if(l+r <= dist){
                        count++;
                    }
                }
            }
        }
        
        for(int l: left){
            list.add(l+1);
        }
        
        for(int r: right){
            list.add(r+1);
        }
        
        return list;
    }
}
