class Solution {
    private void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    
    private void swap(int[][] matrix, int i, int l, int r){
        int temp = matrix[i][l];
        matrix[i][l] = matrix[i][r];
        matrix[i][r] = temp;
    }
    
    private void reverse(int[][] matrix, int i){
        int left = 0, right = matrix[i].length-1;
        
        while(left < right){
            swap(matrix, i, left, right);
            left++; right--;
        }
    }
    
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1){
            return;
        }
        
        //transpose
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                swap(matrix, i, j);
            }
        }
        
        //reverse every row
        for(int i = 0; i < n; i++){
            reverse(matrix, i);
        }
    }
}
