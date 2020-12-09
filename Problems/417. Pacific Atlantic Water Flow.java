class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(matrix.length == 0){
            return  result;
        }
        
        int row = matrix.length, col = matrix[0].length;
        boolean pacific[][] = new boolean[row][col];
        boolean atlantic[][] = new boolean[row][col];
        
        //pacific first row
        for(int i = 0; i < col; i++){
            dfs(matrix, 0, i, pacific, Integer.MIN_VALUE);
        }
        
        //pacific first col
        for(int i = 0; i < row; i++){
            dfs(matrix, i, 0, pacific, Integer.MIN_VALUE);
        }
        
        //atlantic last row
        for(int i = 0; i < col; i++){
            dfs(matrix, row-1, i, atlantic, Integer.MIN_VALUE);
        } 
        
        //atlantic last col
        for(int i = 0; i < row; i++){
            dfs(matrix, i, col-1, atlantic, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    
                    result.add(point);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] matrix, int row, int col, boolean[][] grid, int prev){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length){
            return;
        }
        else if(prev > matrix[row][col]){
            return;
        }
        else if(grid[row][col]){
            return;
        }
        
        grid[row][col] = true;
        
        dfs(matrix, row-1, col, grid, matrix[row][col]);
        dfs(matrix, row+1, col, grid, matrix[row][col]);
        dfs(matrix, row, col-1, grid, matrix[row][col]);
        dfs(matrix, row, col+1, grid, matrix[row][col]);
    }
}
