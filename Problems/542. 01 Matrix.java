class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
                else{
                      matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            for(int[] pos: dir){
                int x = curr[0] + pos[0];
                int y = curr[1] + pos[1];
                
                if(x < 0 || y < 0 || x >= row || y >= col || matrix[curr[0]][curr[1]] >= matrix[x][y]){
                    continue;
                }
                matrix[x][y] = matrix[curr[0]][curr[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
        
        return matrix;
    }
}
