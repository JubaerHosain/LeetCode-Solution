class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length <= 1){
            return 1;
        }
        
        int max = 1, dp[] = new int[pairs.length];
        Arrays.fill(dp,1);
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(final int[] e1,  final int[] e2) { 
   
                if (e1[1] > e2[1]){
                    return 1;
                } 
                else{
                    return -1;
                } 
            } 
        });
        
        for(int j = 1; j < pairs.length; j++){
            for(int i = 0; i < j; i++){
                if(pairs[i][1] < pairs[j][0] && dp[i]+1 > dp[j]){
                    dp[j] = dp[i]+1;
                    max = Math.max(max, dp[j]);
                }
            }
        }
        
        
        return max;
    }
}
