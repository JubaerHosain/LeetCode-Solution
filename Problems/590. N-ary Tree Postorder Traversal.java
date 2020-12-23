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
    public List<Integer> postorder(Node root) {
         List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        postorder(root, result);
        return result;
    }
    
    private void postorder(Node root, List<Integer> list){
        for(Node node: root.children){
            postorder(node, list);
        }
        list.add(root.val);
    }
}
