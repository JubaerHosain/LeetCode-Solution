class Solution {
    private boolean validate(int sum, int k){
        if(sum == 0){
            return true;
        }
        else if(k == 0){
            return false;
        }
        else if(sum%k == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1){
            return false;
        }
        
        for(int i = 0; i < nums.length;  i++){
            int sum = nums[i];
            
            for(int j = i+1;  j < nums.length; j++){
                sum += nums[j];
                
                if(validate(sum, k)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
