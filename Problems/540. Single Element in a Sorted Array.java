class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int low = 0, high = nums.length-1;
        
        if(nums[low] != nums[low+1]){
            return nums[low];
        } else if(nums[high-1] != nums[high]){
            return nums[high];
        }
        
        while(low <= high){
            int mid = low+(high-low)/2;
            
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            } else if((mid%2 == 0 && nums[mid] == nums[mid+1]) 
                      || (mid%2 == 1 && nums[mid-1] == nums[mid])){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return -1;
    }
}
