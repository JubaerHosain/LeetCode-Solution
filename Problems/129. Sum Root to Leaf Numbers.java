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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        return getSum(root, list);
    }
    
    private int getSum(TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return getSumOfList(list);
        }
        
        list.add(root.val);
        
        int left = 0, right = 0;
        if(root.left != null){
            left = getSum(root.left, list);
            if(list.size() > 0){
                list.remove(list.size()-1);
            }
        }
        
        if(root.right != null){
            right = getSum(root.right, list);
            if(list.size() > 0){
                list.remove(list.size()-1);
            }
        }
        
        return left + right;
    }
    
    private int getSumOfList(List<Integer> list){
        int sum = 0;
        for(int x: list){
            sum = (sum*10) + x;
        }
        
        return sum;
    }
}
