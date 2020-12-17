class Solution {
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, grid, visited);
                count++;
            }
        }


        return count;
    }
    
    private void dfs(int u, int[][] grid, boolean[] visited){
        if(visited[u]){
            return;
        }

        visited[u] = true;
        for(int v = 0; v < grid[u].length; v++){
            if(grid[u][v] == 1 && !visited[v]){
                dfs(v, grid, visited);
            }
        }
    }
}
