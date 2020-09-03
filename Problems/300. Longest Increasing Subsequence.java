class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        
        int dp[] = new int[nums.length], max = 1;
        
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0;  j < i; j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = 1 + dp[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}
