class Solution { 
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, Integer>[] adj = new HashMap[n];
        for(int i = 0; i < n; i++){
            adj[i] = new HashMap<Integer, Integer>();
        }
        
        //Making adj list
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            
            adj[u].put(v, w);
        }
        
        boolean[] visited = new boolean[n];
        int[] res = {Integer.MAX_VALUE};
        dfs(adj, src, dst, k, visited, res, 0); 
        
        if(res[0] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res[0];
        }
    }
    
    public void dfs(HashMap<Integer, Integer>[] adj, int src, int dst, int k, boolean[] visited, int[] res, int total){
        if(k < -1){
            return;
        }
        else if(src == dst){
            res[0] = Math.min(res[0], total);
            return;
        }
        
        visited[src] = true;
        for(Map.Entry<Integer, Integer> v: adj[src].entrySet()){
            if(!visited[v.getKey()] && total+v.getValue() <= res[0]){
                dfs(adj, v.getKey(), dst, k-1, visited, res, total+v.getValue());
            }
        }
            
        visited[src] = false;
    }
}
