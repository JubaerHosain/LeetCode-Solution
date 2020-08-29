class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null){
            return new int[0][0];
        }
        
        int row = nums.length;
        int col = nums[0].length;
        
        if(row*col != r*c){
            return nums;
        }
        
        int[][] res = new int[r][c];
        int index = 0;
        for(int a = 0; a < r; a++){
            for(int b = 0; b < c; b++){
                int i = index/col;
                int j = index%col;
                res[a][b] = nums[i][j];
                index++;
            }
        }
            
        
        return res;
    }
}
