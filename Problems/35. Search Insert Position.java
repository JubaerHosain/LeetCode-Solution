class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null){
            return 0;
        }
        
        int left = 0, right = nums.length-1, mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        
        if(target > nums[mid]){
            return mid+1;
        }
        else{
            return mid;
        }
    }
}
