class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        for(; j < nums.length; j++){
            if(nums[i] == nums[j]){
                continue;
            }
            else{
                nums[++i] = nums[j];
            }
        }
        
        return i+1;
    }
}
