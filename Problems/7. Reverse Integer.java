class Solution {
    public int reverse(int x) {
        boolean positive = true;
        if(x < 0){
            positive = false;
            x = -x;
        }
        
        long res = 0;
        while(x != 0){
            int rem = x%10;
            res = res*10 + rem;;
            x /= 10;
        }
        
        if(!positive){
            res = -res;
        }
        
        if( res<-2147483648 || res> 2147483647){
            res = 0;
        }
        return (int)res;
    }
}
