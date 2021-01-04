class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0; i < row; i++){
            if(target <= matrix[i][col-1]){
                return find(matrix[i], target);
            }
        }
        
        return false;
    }
    
    private boolean find(int nums[], int target){
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return false;
    }
}
