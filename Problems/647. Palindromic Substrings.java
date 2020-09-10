class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];    //initially all is false
        
        int result = len;
        for(int i = 0; i < len; i++){              //for length 1
            dp[i][i] = true;
        }
        
        for(int i = 0;  i < len-1; i++){           //for length 2
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                result++;
            }
        }
        
        for(int d = 3; d <= len; d++){
            for(int i = 0;  i < len-d+1; i++){
                int j = i+d-1;
                
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        
        return result;
    }
}
