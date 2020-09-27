class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int max = 0, point = 0;
        int i = 0, j = tokens.length-1;
        
        while(i <= j){
            if(P >= tokens[i]){
                point++;
                P -= tokens[i++];
                max = Math.max(point, max);
            }
            else if(point > 0){
                point--;
                P += tokens[j--];
            }
            else{
                return max;
            }
        }
        
        return max;
    }
}
