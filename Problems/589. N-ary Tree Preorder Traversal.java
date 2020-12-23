/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        preorder(root, result);
        return result;
    }
    
    private void preorder(Node root, List<Integer> list){
        list.add(root.val);
        
        for(Node node: root.children){
            preorder(node, list);
        }
    }
}
