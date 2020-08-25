class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        if(n < 1){
            return matrix;
        }
        
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        int dir = 0, val = 1;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    matrix[top][i] = val;
                    val++;
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    matrix[i][right] = val;
                    val++;
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = val;
                    val++;
                }
                bottom--;
            }
            else{
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = val;
                    val++;
                }
                left++;
            }

            dir = (dir+1)%4;
        }
        
        return matrix;
    }
}
