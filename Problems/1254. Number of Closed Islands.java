class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        //first row and last row
        for(int j = 0; j < col; j++){
            dfs(0, j, grid);
            dfs(row-1, j, grid);
        }
        
         //first col and last col
        for(int i = 0; i < row; i++){
            dfs(i, 0, grid);
            dfs(i, col-1, grid);
        }
        
        int count = 0;
        for(int i = 1; i < row-1; i++){
            for(int j = 1; j < col-1; j++){
                if(grid[i][j] == 0){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        
        
        return count;
    }
    
    private void dfs(int x, int y, int[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1){
            return;
        }
        
        grid[x][y] = 1;
        dfs(x-1, y, grid);
        dfs(x+1, y, grid);
        dfs(x, y-1, grid);
        dfs(x, y+1, grid);
    }
}
