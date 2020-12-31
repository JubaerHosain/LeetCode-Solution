class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] dp = new int[101];
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]]++;
        }
        
        for(int i = 1; i < dp.length; i++){
            dp[i] += dp[i-1];
        }
        
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                result[i] = 0;
            } else {
                result[i] = dp[nums[i]-1];
            }
        }
        
        return result;
    }
}
