class Solution {
    public int minFallingPathSum(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] dp = new int[row][col];
        
        for(int i = 0; i < col; i++){
            dp[0][i] = A[0][i];
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                int v1 = dp[i-1][j], v2 = 1000, v3 = 1000;
                
                if(j > 0){
                    v2 = dp[i-1][j-1];
                }
                if(j < col-1){
                    v3 = dp[i-1][j+1];
                }
            
                dp[i][j] = A[i][j] + Math.min(v1, Math.min(v2, v3));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            min  = Math.min(min, dp[row-1][i]);
        }
        
        return min;
    }
}
