class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        int result = 0;
        
        if((n&1) == 0){
            int x = n/2 - 1;
            int mid = 2*x + 2;
            
            result = 1;
            x--;
            while(x >= 0){
                int a = 2*x + 1;
                
                result += mid-a;
                x--;
            }
        }
        else{
            int x = (n/2)-1;
            int mid = 2 * (n/2) + 1;
            
            while(x >= 0){
                int a = 2*x+1;
                
                result += mid-a;
                x--;
            }
        }
        
        return result;
    }
}
