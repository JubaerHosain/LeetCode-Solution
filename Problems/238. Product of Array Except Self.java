class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zero = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }
            else{
                product *= nums[i];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(zero > 1){
                nums[i] = 0;
            }
            else if(zero == 1){
                if(nums[i] == 0){
                    nums[i] = product;
                }
                else{
                    nums[i] = 0;
                }
            }
            else{
                nums[i] = product/nums[i];
            }
        }
        
        return nums;
    }
}
