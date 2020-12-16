class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int count = 0;
        boolean[] visited = new boolean[rooms.size()];
        
        dfs(0, rooms, visited);
        
        for(boolean vis: visited){
            if(!vis){
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int u, List<List<Integer>> rooms, boolean[] visited){ 
        visited[u] = true;
        
        for(int v: rooms.get(u)){
            if(!visited[v]){
                dfs(v, rooms, visited);
            }
        }
    }
}
