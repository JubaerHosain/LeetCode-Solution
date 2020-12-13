class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            sum[i] = nums[i] + sum[i-1];
        }
        
        
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                res[i] = Math.abs((nums[i]*(n-1)) - (sum[n-1]-nums[i]));
            }
            else if(i == n-1){
                res[i] = Math.abs((nums[i]*(n-1)) - sum[n-2]);
            }
            else{
                int left = Math.abs((nums[i]*i) - sum[i-1]);
                int right = Math.abs((sum[n-1]-sum[i]) - (nums[i] * (n-i-1)));
                res[i] = left+right;
            }
            
        }
        
        return res;
    }
}
