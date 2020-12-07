class Solution {
    enum Color{
        WHITE, RED, BLACK;
    }
    
    public boolean isBipartite(int[][] graph) {
        Color[] color = new Color[graph.length];
        Arrays.fill(color, Color.WHITE);
        
        for(int i = 0; i < graph.length; i++){
            if(color[i] == Color.WHITE){
                if(!bfs(graph, i, color)){
                    return false;
                }
            }
        }
        
        
        return true;
    }
    
    private boolean bfs(int[][] graph, int start, Color[] color){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        color[start] = Color.RED;
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            
            for(int v: graph[u]){
                    if(color[v] == Color.WHITE){
                        if(color[u] == Color.RED){
                            color[v] = Color.BLACK;
                        }
                        else{
                            color[v] = Color.RED;
                        }
                    
                        queue.offer(v);
                    }
                    else if(color[u] == color[v]){
                        return false;
                    }
            }
        }  
        
        return true;
    }
}
