class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        
        if(n <= 7) {
            return n*(n+1)/2;
        }
            
        int week = n/7;
        int mod = n%7;
        for(int i = 0; i < week; i++) {
            sum += getSum(i, i+7);
        }
        
        if(mod >= 1) {
            sum += getSum(week, week+mod);
        }
        
        return sum;    
    }
    
    private int getSum(int m, int n) {
        if(m == 0) {
            return n*(n+1)/2;
        }
        
        return (n*(n+1)/2) - (m*(m+1)/2);
    }
}
