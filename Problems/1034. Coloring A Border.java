class Solution {
    private void dfs(int r, int c, int[][] grid, boolean[][] visited, int val, int color){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
          || grid[r][c] != val || visited[r][c]){
            return;
        }
        
        visited[r][c] = true;
        boolean isBorder = false; 
        if(r == 0 || c == 0 || r == grid.length-1 || c == grid[0].length-1
          || grid[r+1][c] != val || grid[r-1][c] != val || grid[r][c+1] != val || grid[r][c-1] != val){
            isBorder = true;
        }
        
        dfs(r+1, c, grid, visited, val, color);
        dfs(r-1, c, grid, visited, val, color);
        dfs(r, c+1, grid, visited, val, color);
        dfs(r, c-1, grid, visited, val, color);
        
        if(isBorder){
            grid[r][c] = color;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int r, int c, int color) {
        if(grid[r][c] == color){
            return grid;
        } 
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(r, c, grid, visited, grid[r][c], color);
        
        return grid;
    }
}
