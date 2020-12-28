class Solution {
    class Node{
        String key;
        double val;
        
        public Node(String key, double val){
            this.key = key;
            this.val = val;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            
            result[i] = DFS(src, dest, new HashSet<>(), graph);
        }
        
        return result;
    }
    
    private Map<String, List<Node>> buildGraph(List<List<String>> edge, double[] val){
        Map<String, List<Node>> graph = new HashMap<>();
        
        for(int i = 0; i < edge.size(); i++){
            String src = edge.get(i).get(0);
            String dest = edge.get(i).get(1);
            
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            
            graph.get(src).add(new Node(dest, val[i]));
            graph.get(dest).add(new Node(src, 1/val[i]));
        }
        
        return graph;
    }
    
    private double DFS(String src, String dest, HashSet<String> visited, Map<String, List<Node>> graph){
        if(!graph.containsKey(src) || !graph.containsKey(dest)){
            return -1;
        } else if(src.equals(dest)){
              return 1.0;
        }
        
        visited.add(src);
        for(Node node: graph.get(src)){
            if(!visited.contains(node.key)){
                double result = DFS(node.key, dest, visited, graph);
                if(result != -1){
                    return result*node.val;
                }
            }
        }
        
        return -1;
    }
}
