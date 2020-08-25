class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        if(matrix.length < 1){
            return list;
        }
        
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        int dir = 0;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else{
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            
            dir = (dir+1)%4;
        }
        
        return list;
    }
}
