class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        
        boolean possible = false;
        int i;
        for(i = nums.length-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                Arrays.sort(nums, i, nums.length);
                
                for(int k = i; k < nums.length; k++){
                    if(nums[i-1] < nums[k]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[k];
                        nums[k] = temp;
                        break;
                    }
                }
                
                possible = true;
                break;
            }
        }
        
        
        if(!possible){
            Arrays.sort(nums);
        }
    }
}
