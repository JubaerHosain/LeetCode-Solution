class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int sum = 0, cur = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        for(int i = nums.length-1; i >= 0; i--) {
            cur += nums[i];
            sum -= nums[i];
            res.add(nums[i]);
            
            if(cur > sum){
                return res;
            }
        }
        
        return res;
    }
} 
