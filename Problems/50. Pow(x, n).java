class Solution {
    public double myPow(double x, int n) {
        return getPow(x,n);
    }
    
    private double getPow(double x, long n){
        if(n == 0){
            return 1.0;
        } else if(n == 1){
            return x;
        } else if(n < 0) {
            return getPow(1/x, -n);
        }
        
        double result = getPow(x*x, n/2);
        if(n%2 == 1){
            result *= x;
        }
        
        return result;
    }
}
