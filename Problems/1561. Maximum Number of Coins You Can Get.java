class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int res = 0, i = 0, j = piles.length-2, k = piles.length-1;
        while(i < j){
            res += piles[j];
            i++;
            k -= 2;
            j -= 2;
        }
        
        return res;
    }
}
