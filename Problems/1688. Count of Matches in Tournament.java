class Solution {
    public int numberOfMatches(int n) {
        int total = 0;
        
        while(n != 1){
            int match = n/2;
            n = (n%2 == 0) ? match:match+1;
            total += match;
        }
        
        return total;
    }
}
