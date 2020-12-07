class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y] == '1'){
                    dfs(grid, x, y);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] A, int x, int y){
        if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == '0'){
            return;
        }
        A[x][y] = '0';

        dfs(A, x+1, y);
        dfs(A, x-1, y);
        dfs(A, x, y+1);
        dfs(A, x, y-1);
    }
}
