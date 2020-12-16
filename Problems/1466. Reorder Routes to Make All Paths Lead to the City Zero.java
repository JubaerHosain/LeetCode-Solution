class Solution {
    public int minReorder(int n, int[][] path) {
        Map<Integer, HashSet<Integer>> map = new HashMap();
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < path.length; i++){
            int u = path[i][0];
            int v = path[i][1];
            
            if(map.containsKey(u)){
                map.get(u).add(v);
            }
            else{
                map.put(u, new HashSet<>());
                map.get(u).add(v);
            }
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        return dfs(0, adj, map, visited);
    }
    
    private int dfs(int u, List<Integer>[] adj, Map<Integer, HashSet<Integer>> map, boolean[] visited){
        if(visited[u]){
            return 0;
        }
        
        int count = 0;
        visited[u] = true;
        for(int v: adj[u]){
            if(!visited[v]){
                if(map.containsKey(u) && map.get(u).contains(v)){
                    count+=1;
                }
                int c = dfs(v, adj, map, visited);
                count += c;
            }
        }
        
        return count;
    }
}
