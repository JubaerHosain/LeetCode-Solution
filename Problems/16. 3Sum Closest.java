class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int result = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1, k = nums.length-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(target-sum);
                
                if(diff < min){
                    min = diff;
                    result = sum;
                }
                
                if(sum == target){
                    return sum;
                }
                else if(sum > target){
                    k--;
                }
                else{
                    j++;
                }
            }
            
        }

        return result;
    }
}
