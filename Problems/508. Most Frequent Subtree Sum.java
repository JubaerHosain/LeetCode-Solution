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
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int rootSum = findSubtreeSum(root, map);
        
        int maxCount = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            int count = map.get(key);
            
            if(count == maxCount){
                list.add(key);
            } else if(count > maxCount){
                maxCount = count;
                list.clear();
                list.add(key);
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for(int val: list){
            result[index++] = val;
        }
        
        return result;
    }
    
    private int findSubtreeSum(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        
        int leftSum = findSubtreeSum(root.left, map);
        int rightSum = findSubtreeSum(root.right, map);
        int subtreeSum = root.val+leftSum+rightSum;
        
        if(!map.containsKey(subtreeSum)){
            map.put(subtreeSum, 1);
        } else {
            map.put(subtreeSum, map.get(subtreeSum)+1);
        }
        
        return subtreeSum;
    }
}
