class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] counter = new int[N+1];
        
        for(int i = 0; i < trust.length; i++){
            counter[trust[i][0]]--;
            counter[trust[i][1]]++;
        }
        
        for(int i = 1; i <= N; i++){
            if(counter[i] == N-1) return i;
        }
        
        return -1;
    }
}
