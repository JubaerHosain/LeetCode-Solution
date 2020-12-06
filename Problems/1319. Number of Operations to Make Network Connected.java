class Solution {
    public int makeConnected(int n, int[][] edges) {
        if(edges.length < n-1){
            return -1;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        
        boolean visited[] = new boolean[n];
        int component = 0;
        
        for(int u = 0; u < n; u++){
            if(!visited[u]){
                dfs(adjList, visited, u);
                component++;
            }
        }
        
        return component-1;
    }
    
    private void dfs(List<List<Integer>> adjList, boolean visited[], int u){
        visited[u] = true;
        
        List<Integer> adj = adjList.get(u);
        for(int v: adj){
            if(!visited[v]){
                dfs(adjList, visited, v);
            }
        }
        
    }
}
