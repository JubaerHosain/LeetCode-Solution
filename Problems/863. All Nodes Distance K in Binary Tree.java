/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(parent, root);
        
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                visited.add(current);
                
                if(K == 0){
                    result.add(current.val);
                }
                
                if(parent.containsKey(current) && !visited.contains(parent.get(current))){
                    queue.add(parent.get(current));
                }
                
                if(current.left != null && !visited.contains(current.left)){
                    queue.add(current.left);
                }
                
                if(current.right != null && !visited.contains(current.right)){
                    queue.add(current.right);
                }
            }
            K--;
            if(K < 0){
                break;
            }
        }
        
        return result;
    }
    
    private void findParent(HashMap<TreeNode, TreeNode> parent, TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            parent.put(root.left, root);
        }
        
        if(root.right != null){
            parent.put(root.right, root);
        }
        
        findParent(parent, root.left);
        findParent(parent, root.right);
    }
}
