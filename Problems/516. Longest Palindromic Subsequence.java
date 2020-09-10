class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 2;
            }
            else{
                dp[i][i+1] = 1;
            }
        }
        
        
        for(int l = 3; l <= s.length();  l++){
            for(int i = 0; i < s.length()-l+1; i++){
                int j = i+l-1;
                
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j]  = 2 + dp[i+1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        
        
        return dp[0][s.length()-1];
    }
}
