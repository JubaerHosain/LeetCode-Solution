class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            count += getNegative(grid[i]);
        }
        
        return count;
    }
    
    private int getNegative(int[] nums){
        int low = 0, high = nums.length;
        
        while(low < high){
            int mid = (low+high)/2;
            
            if(nums[mid] < 0){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        return nums.length-low;
    }
}
