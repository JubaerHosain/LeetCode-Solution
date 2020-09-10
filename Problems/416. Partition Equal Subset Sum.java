class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length <= 1){
            return false;
        }
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        if((sum & 1) == 1){
            return false;
        }
        
        boolean[][] dp = new boolean[nums.length+1][(sum/2)+1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length;  i++){
            dp[i][0] = true;
            
            for(int j = 1; j <= sum/2; j++){
                if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = (dp[i-1][j-nums[i-1]] || dp[i-1][j]);
                }
            }
        }
        
        return dp[nums.length][sum/2];
    }
}
