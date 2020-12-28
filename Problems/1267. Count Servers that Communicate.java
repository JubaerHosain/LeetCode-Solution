class Solution {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[] rowCount = new int[row];
        int[] colCount = new int[col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                rowCount[i] += grid[i][j];
                colCount[j] += grid[i][j];
            }
        }
        
        int count = 0;
        for(int i = 0; i < row; i++){
             for(int j = 0; j < col; j++){
                 if(grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)){
                     count++;
                 }
             }
        }
        
        return count;
    }
}
