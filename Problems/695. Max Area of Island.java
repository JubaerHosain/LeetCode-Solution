class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                if(grid[x][y] == 1){
                    int count = dfs(x, y, grid);
                    max = Math.max(max, count);
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int x, int y, int[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0){
            return 0;
        }
        
        grid[x][y] = 0;
        return 1 + dfs(x-1, y, grid) + dfs(x, y-1, grid) + dfs(x+1, y, grid) + dfs(x, y+1, grid);
    } 
}
