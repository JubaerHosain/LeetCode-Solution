class Solution {
    public int numberOfMatches(int n) {
        if(n == 1){
            return 0;
        } else if(n%2 == 0){
            return numberOfMatches(n/2) + n/2;
        } else {
            return numberOfMatches((n-1)/2+1) + (n-1)/2;
        }
    }
}
