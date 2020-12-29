class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = buildGraph(paths);
        
        int[] color = new int[n+1];
        for(int u = 1; u <= n; u++){
            if(color[u] == 0){
                DFS(u, graph, color);
            }
        }
        
        return Arrays.copyOfRange(color, 1, color.length);
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] paths){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < paths.length; i++){
            int x = paths[i][0], y = paths[i][1];
            
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        return graph;
    }
    
    private void DFS(int u, Map<Integer, List<Integer>> graph, int[] color){
        color[u] = getColor(u, graph, color);
        
        List<Integer> list = graph.get(u);
        if(list == null){
            return;
        }
        for(int v: list){
            if(color[v] == 0){
                DFS(v, graph, color);
            }
        }
    }
    
    private int getColor(int u, Map<Integer, List<Integer>> graph, int[] color){
        boolean[] colors = new boolean[5];
        List<Integer> list = graph.get(u);
        
        if(list == null){
            return 1;
        }
        
        for(int node: list){
            colors[color[node]] = true;
        }
        
        for(int i = 1; i <= 4; i++){
            if(!colors[i]){
                return i;
            }
        }
        
        return 1;
    }
}
