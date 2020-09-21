class Solution {
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public int[] prevPermOpt1(int[] A) {
        int len = A.length, a = -1, b = -1;
        
        for(int i = len-1; i > 0; i--){
            if(A[i-1] > A[i]){
                a = i-1;
                break;
            }
        }
        
        if(a < 0){
            return A;
        }
        
        for(int i = a+1; i < len; i++){
            if(A[a] > A[i] && (b < 0 || A[b]<A[i])){
                b = i;
            }
        }
        
        swap(A, a, b);
        
        return A;
    }
}
