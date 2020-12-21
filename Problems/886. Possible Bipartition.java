class Solution {
    enum Color{
        WHITE, RED, BLACK;
    }
    
     private boolean bfs(ArrayList<Integer>[] graph, int start, Color[] color){
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
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
          ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList();

        // note that this is bi-directional
        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        Color[] color = new Color[N+1];
        Arrays.fill(color, Color.WHITE);
        for(int i = 1; i < N; i++){
            if(color[i] == Color.WHITE){
                if(!bfs(graph, i, color)){
                    return false;
                }
            }
        }
        
        return true;
    }
}
