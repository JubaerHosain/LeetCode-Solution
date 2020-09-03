class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        else if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0 && dp[i] <= dp[j]){ 
                    dp[i] = 1 + dp[j];
                    if(dp[i] > max){
                        max = dp[i];
                    }
                }
            }
        }
        
        
        int prev = -1;
        for(int i = dp.length - 1; i >= 0; i--){
            if((prev%nums[i] == 0 || prev == -1) && dp[i] == max){
                res.add(nums[i]);
                prev = nums[i];
                max--;
            }
        }
        
        return res;
    }
}
