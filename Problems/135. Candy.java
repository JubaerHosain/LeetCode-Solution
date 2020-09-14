class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length, sum = 0;
        int[] dp1 = new int[len], dp2 = new int[len]; 
        
        
        dp1[0] = 1;
        for(int i = 1; i < len; i++){
            dp1[i] = 1;
            
            if(ratings[i] > ratings[i-1]){
                dp1[i] = 1+dp1[i-1];
            }
        }
        
        dp2[len-1] = 1;
        for(int i = len-2; i >= 0; i--){
            dp2[i] = 1;
            
            if(ratings[i] > ratings[i+1]){
                dp2[i] = 1+dp2[i+1];
            }
        }
        
        for(int i = 0; i < len; i++){
            sum += Math.max(dp1[i], dp2[i]);
        }
        
        return sum;
    }
}
