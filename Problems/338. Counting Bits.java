class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        
        for(int i = 1; i <= num; i++){
            int x = i;
            if((i & 1) == 0){
                dp[i] = dp[x>>1];
            }
            else{
                dp[i] = 1 + dp[x>>1];
            }
        }  
        
        return dp;
    }
}
