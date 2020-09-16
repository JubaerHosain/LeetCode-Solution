class Solution {
    public int minCost(String s, int[] cost) {
        int cnt = 0;
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i)){
                cnt += Math.min(cost[i-1], cost[i]);
                cost[i] = Math.max(cost[i-1], cost[i]);
            }
        }
        return cnt;
    }
}
