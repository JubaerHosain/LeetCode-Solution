class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length < 3){
            return result;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            //skip duplicates
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int target = -nums[i];
            twoSum(result, nums, target, i+1, nums.length-1);
        }
        
        return result;
    }
    
    private void twoSum(List<List<Integer>> result, int[] nums, int target, int left, int right){
        while(left < right){
            if(nums[left] + nums[right] == target){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(-target);
                triplet.add(nums[left]);
                triplet.add(nums[right]);
                result.add(triplet);
                
                left++; right--;
                while(left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right+1]){
                    right--;
                }
            }
            else if(nums[left]+nums[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
    }
}
