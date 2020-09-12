class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        boolean[][] grid =  new boolean[N][N];
        for(int i = 0; i < N; i++){
             Arrays.fill(grid[i], true);
        }
        for(int[] m:  mines){
            grid[m[0]][m[1]] = false;
        }
        
        int res = 0, l;
        for(int i  = 0; i < N; i++){
            if(i-res < 0 || i+res >= N){
                continue;
            }
            
            for(int j = 0; j < N; j++){
                if(j-res < 0 || j+res >= N){
                    continue;
                }
                
                l = 0;
                while(true){
                    if(i-l >= 0 && grid[i-l][j]  &&
                       j-l >= 0 && grid[i][j-l]  &&
                       i+l <  N && grid[i+l][j]  &&
                       j+l <  N && grid[i][j+l]){
                        
                        l++;
                    }
                    else{
                        break;
                    }
                }
                
                res = Math.max(res, l);
            }
        }
        
        return res;
    }
}
