class Solution {
    public int minCostToMoveChips(int[] position) {
        int[] cnt =  new int[2];
        
        for(int i = 0; i < position.length; i++){
            cnt[position[i]&1]++;
        }
        
        return Math.min(cnt[0], cnt[1]);
    }
}
