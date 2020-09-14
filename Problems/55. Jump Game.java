class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length, max = 0; 
        
        for(int i = 0; i < len; i++){
            if(max < i){
                return false;
            }
            else if(max >= len-1){
                return true;
            }
            
            max = Math.max(max, i+nums[i]);
        }
        
        return true;
    }
}
